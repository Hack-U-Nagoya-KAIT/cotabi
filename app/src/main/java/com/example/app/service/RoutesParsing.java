package com.example.app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoutesParsing {
    public static void Parsing(String json){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode routeNode = rootNode.get("routes").get(0);
            int distanceMeters = routeNode.get("distanceMeters").asInt();
            String duration = routeNode.get("duration").asText();

            System.out.println("Distance in meters: " + distanceMeters);
            System.out.println("Duration: " + duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
