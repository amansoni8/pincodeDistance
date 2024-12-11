package com.example.pindistance.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pindistance.entity.Route;
import com.example.pindistance.repository.RouteRepository;

@Service
public class RouteService {
	
	 private final RestTemplate restTemplate;

	    public RouteService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private GoogleMapsService googleMapsService;

    @Cacheable(value = "routes", key = "#fromPincode + '-' + #toPincode") 
    public Route getRoute(String fromPincode, String toPincode) throws Exception {
        return routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode)
                .orElseGet(() -> {
                    try {
                        Map<String, Object> routeDetails = googleMapsService.getRouteDetails(fromPincode, toPincode);
                        Route route = new Route();
                        route.setFromPincode(fromPincode);
                        route.setToPincode(toPincode);
                        route.setDistance((double) routeDetails.get("distance"));
                        route.setDuration((String) routeDetails.get("duration"));
                        route.setRouteDetails((String) routeDetails.get("routeDetails"));
                        return routeRepository.save(route);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }
    public String getRouteData(String fromPincode, String toPincode) {
        String url = String.format("https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&key=YOUR_API_KEY", 
                                    fromPincode, toPincode);
        return restTemplate.getForObject(url, String.class);
    }
}
