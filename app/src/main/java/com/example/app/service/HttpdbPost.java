package com.example.app.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpdbPost {
    // public static void main(String[] args) {
    //     RestTemplate restTemplate = new RestTemplate();

    //     String url = "http://localhost:8080/api/db/create/comp";
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);

    //     String requestBody = "{\"designNum\":\"777\"}";

    //     ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers), String.class);

    //     if (response.getStatusCode().is2xxSuccessful()) {
    //         String responseBody = response.getBody();
    //         System.out.println("Response: " + responseBody);
    //     } else {
    //         System.out.println("Request failed with status code: " + response);
    //     }
    // }
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/db/create/spot";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"companion\":{\"companionId\":\"1\"},\"spotLon\":\"7.777\",\"spotLat\":\"7.777\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers), String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println("Response: " + responseBody);
        } else {
            System.out.println("Request failed with status code: " + response);
        }
    }
}

