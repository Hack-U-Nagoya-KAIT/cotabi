package com.example.app.service;

import com.example.app.model.RouteResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoutesParsing {
    public static RouteResponse Parsing(String json){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            RouteResponse distdura = new RouteResponse();

            JsonNode routeNode = rootNode.get("routes").get(0);
            
            double distance = routeNode.get("distanceMeters").asDouble();
            distdura.setDistance(distance/1000);
            
            String duration = routeNode.get("duration").asText();
            String numberStr = duration.replaceAll("\\D+", ""); // 正規表現で数字以外の文字を削除
            distdura.setDuration(Double.parseDouble(numberStr)/60); // 数字文字列を整数に変換

            return distdura;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
