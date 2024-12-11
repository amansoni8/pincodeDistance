package com.example.pindistance.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;

import java.util.Map;
import java.util.HashMap;

@Service
public class GoogleMapsService {

    @Value("${google.api.key}")
    private String apiKey;

    public Map<String, Object> getRouteDetails(String fromPincode, String toPincode) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();
        DirectionsApiRequest request = DirectionsApi.getDirections(context, fromPincode, toPincode);
        DirectionsResult result = request.await();

        if (result.routes.length > 0) {
            double distance = result.routes[0].legs[0].distance.inMeters / 1000.0;
            String duration = result.routes[0].legs[0].duration.humanReadable;
            String routeDetails = result.routes[0].overviewPolyline.getEncodedPath();

            Map<String, Object> response = new HashMap<>();
            response.put("distance", distance);
            response.put("duration", duration);
            response.put("routeDetails", routeDetails);
            return response;
        } else {
            throw new Exception("No routes found");
        }
    }
}


