package com.example.app.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.example.app.model.RouteRequest;

public class RouteService {

    public static String RoutesAPI(RouteRequest routeRequest) {
        try {
            // // Create origin and destination objects
            // JSONObject origin = new JSONObject()
            // .put("address", "1030 Shimoogino, Atsugi-shi, Kanagawa");

            // JSONObject destination = new JSONObject()
            // .put("address", "2 Takashima, Nishi-ku, Yokohama City, Kanagawa Prefecture");

            // Create JSON data
            JSONObject originLatLng = new JSONObject()
                    .put("latitude", routeRequest.getOriginLat())
                    .put("longitude", routeRequest.getOriginLng());

            JSONObject originLocation = new JSONObject()
                    .put("latLng", originLatLng);

            JSONObject origin = new JSONObject()
                    .put("location", originLocation);

            JSONObject destinationLatLng = new JSONObject()
                    .put("latitude", routeRequest.getDestLat())
                    .put("longitude", routeRequest.getOriginLng());

            JSONObject destinationLocation = new JSONObject()
                    .put("latLng", destinationLatLng);

            JSONObject destination = new JSONObject()
                    .put("location", destinationLocation);

            JSONObject requestData = new JSONObject()
                    .put("origin", origin)
                    .put("destination", destination)
                    .put("travelMode", "DRIVE")
                    .put("computeAlternativeRoutes", false)
                    .put("languageCode", "ja-JP");

            // API Key and URL
            String apiKey = "AIzaSyBA3UydwKBcKwXSZUAGw47t09lTIKQuwrw";
            String apiUrl = "https://routes.googleapis.com/directions/v2:computeRoutes";

            // Create HTTP connection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-Goog-Api-Key", apiKey);
            connection.setRequestProperty("X-Goog-FieldMask",
                    "routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline");
            connection.setDoOutput(true);

            // Send JSON data
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(requestData.toString());
                outputStream.flush();
            }

            // Get response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println("Response:");
                System.out.println(response.toString());
                return response.toString();
            } else {
                System.out.println("Request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
        return null;
    }
}