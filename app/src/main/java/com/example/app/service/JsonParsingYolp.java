package com.example.app.service;

import java.util.ArrayList;
import java.util.List;

import com.example.app.model.YolpData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParsingYolp {
    public static List<YolpData> json(String... jsonDataArray) {
        List<YolpData> dataList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (String jsonData : jsonDataArray) {
            try {
                JsonNode rootNode = objectMapper.readTree(jsonData);

                JsonNode featureArrayNode = rootNode.get("Feature");
                if (featureArrayNode.isArray()) {
                    for (JsonNode featureNode : featureArrayNode) {
                        JsonNode propertyNode = featureNode.get("Property");
                        JsonNode geometryNode = featureNode.get("Geometry");

                        String name = featureNode.get("Name").asText();
                        String tag = propertyNode.get("Genre").get(0).get("Name").asText();
                        String address = propertyNode.get("Address").asText();

                        String coordinates = geometryNode.get("Coordinates").asText();

                        // Coordinatesを分割してlatとlonを取得
                        String[] coordParts = coordinates.split(",");
                        double lat = Double.parseDouble(coordParts[1]);
                        double lon = Double.parseDouble(coordParts[0]);

                        // YolpDataオブジェクトを作成してリストに追加
                        YolpData data = new YolpData(name, lat, lon, tag, address);
                        dataList.add(data);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // dataListの内容を表示
        for (YolpData data : dataList) {
            System.out.println("Name: " + data.getName());
            System.out.println("lat: " + data.getLat());
            System.out.println("lon: " + data.getLon());
            System.out.println("tag: " + data.getTag());
            System.out.println("address: " + data.getAddress());
        }
        return dataList;
    }
}
