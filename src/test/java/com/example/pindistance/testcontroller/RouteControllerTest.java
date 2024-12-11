package com.example.pindistance.testcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.pindistance.controller.RouteController;
import com.example.pindistance.entity.Route;
import com.example.pindistance.service.RouteService;

@WebMvcTest(RouteController.class)
public class RouteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RouteService routeService;

    @Test
    public void testHomeEndpoint() throws Exception {
        mockMvc.perform(get("/api/routes/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("test"));
    }

    @Test
    public void testGetRouteEndpoint() throws Exception {
        // Mocking the service response
        Route mockRoute = new Route();
        mockRoute.setFromPincode("110001");
        mockRoute.setToPincode("110002");
        mockRoute.setDistance(5.0);
        mockRoute.setDuration("10 mins");
        mockRoute.setRouteDetails("Sample route details");

        when(routeService.getRoute("110001", "110002")).thenReturn(mockRoute);

        // Test the /api/routes endpoint
        mockMvc.perform(get("/api/routes")
                        .param("fromPincode", "110001")
                        .param("toPincode", "110002"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"fromPincode\":\"110001\",\"toPincode\":\"110002\",\"distance\":5.0,\"duration\":\"10 mins\",\"routeDetails\":\"Sample route details\"}"));
    }

    @Test
    public void testGetRouteEndpointWithException() throws Exception {
        // Mocking the service to throw an exception
        when(routeService.getRoute("110001", "110002")).thenThrow(new RuntimeException("Google Maps API error"));

        // Test the /api/routes endpoint when an exception occurs
        mockMvc.perform(get("/api/routes")
                        .param("fromPincode", "110001")
                        .param("toPincode", "110002"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Google Maps API error"));
    }
}