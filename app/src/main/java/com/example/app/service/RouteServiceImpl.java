package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.model.RouteRequest;
import com.example.app.model.RouteResponse;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

@Service
public class RouteServiceImpl implements RouteService {
    private static final String API_KEY = "AIzaSyBA3UydwKBcKwXSZUAGw47t09lTIKQuwrw";
    
    @Override
    public RouteResponse calculateRoute(RouteRequest routeRequest) {
        GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey(API_KEY)
                    .build();

        DirectionsResult directionsResult;
        try {
            directionsResult = DirectionsApi.newRequest(context)
                    .mode(TravelMode.DRIVING)
                    .origin(routeRequest.getOriginLat() + "," + routeRequest.getOriginLng())
                    .destination(routeRequest.getDestLat() + "," + routeRequest.getDestLng())
                    .await();
        } catch (Exception e) {
            e.printStackTrace();
            // エラーハンドリングを適切に行う
            return null;
        }

        RouteResponse response = new RouteResponse();
        response.setDistance(directionsResult.routes[0].legs[0].distance.humanReadable);
        response.setDuration(directionsResult.routes[0].legs[0].duration.humanReadable);
        response.setPolyline(directionsResult.routes[0].overviewPolyline.getEncodedPath());
        return response;
    }
}
