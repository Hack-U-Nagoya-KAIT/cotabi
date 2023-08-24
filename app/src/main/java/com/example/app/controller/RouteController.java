package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.RouteRequest;
import com.example.app.model.RouteResponse;
import com.example.app.service.RouteService;

@RestController
public class RouteController {
    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/calculate-route")
    public RouteResponse calculateRoute(@RequestBody RouteRequest routeRequest) {
        return routeService.calculateRoute(routeRequest);
    }
}
