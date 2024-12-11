package com.example.pindistance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pindistance.entity.Route;
import com.example.pindistance.service.RouteService;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;
    
    @GetMapping("/test")
    public String home() {
    	return "test";
    }
    

    @GetMapping
    public ResponseEntity<?> getRoute(
            @RequestParam String fromPincode,
            @RequestParam String toPincode) {
        try {
            Route route = routeService.getRoute(fromPincode, toPincode);
            return ResponseEntity.ok(route);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

