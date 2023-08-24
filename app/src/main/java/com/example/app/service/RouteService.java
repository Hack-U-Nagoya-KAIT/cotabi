package com.example.app.service;

import com.example.app.model.RouteRequest;
import com.example.app.model.RouteResponse;

public interface RouteService {
    RouteResponse calculateRoute(RouteRequest routeRequest);
}