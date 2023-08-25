package com.example.app.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpdbPost {

    public Long CC()  {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/db/create/comp";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"designNum\":\"777\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers), String.class);
        System.out.println("あああ");
        return Long.parseLong(response.getBody());
        }
        // if (response.getStatusCode().is2xxSuccessful()) {
        //     String responseBody = response.getBody();

        //     // JSONデータを解析して、特定のフィールドを取得
        //     ObjectMapper objectMapper = new ObjectMapper();
        //     JsonNode jsonNode = objectMapper.readTree(responseBody);
        //     Long id = jsonNode.get("id").asLong(); // "id"は適切なフィールド名に置き換える

        //     // idを使用する処理
        //     System.out.println("Generated ID: " + id);
        //     return id;
        // } else {
        // System.out.println("Request failed with status code: " + response);
        // }
        // if (response.getStatusCode().is2xxSuccessful()) {
        //     String responseBody = response.getBody();
        //     System.out.println("Response: " + responseBody);
        // } else {
        //     System.out.println("Request failed with status code: " + response);
        // }


    public void cSpot(Long id, double lon, double lat, String name, String address) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/db/create/spot";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"companion\":{\"companionId\":\"" + id + "\"},\"spotLon\":\"" + lon
                + "\",\"spotLat\":\"" + lat + "\",\"spotName\":\""+name+"\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers),
                String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println("Response: " + responseBody);
        } else {
            System.out.println("Request failed with status code: " + response);
        }
    }

    public void cRoutes(Long id, double distance, double duration) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/db/create/Route";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"companion\":{\"companionId\":\"" + id + "\"},\"distance\":\"" + distance
                + "\",\"duration\":\"" + duration + "\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers),
                String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println("Response: " + responseBody);
        } else {
            System.out.println("Request failed with status code: " + response);
        }
    }
}
