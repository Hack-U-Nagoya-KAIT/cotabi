package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Yolp {
    public static String getYolpData(double latitude, double longitude) {
        String baseUrl = "https://map.yahooapis.jp/search/local/V1/localSearch";
        String apiKey = "dj00aiZpPWNvY0Z0MnpFaEJkWiZzPWNvbnN1bWVyc2VjcmV0Jng9N2Q-"; // ここに実際のAPIキーを入力

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
            baseUrl + "?appid=" + apiKey + "&device=mobile&gc=01&lat="+latitude+"&lon="+longitude+"&dist=3",
            String.class
        );

        String responseBody = response.getBody();
        System.out.println(responseBody);
        return responseBody;
    }
}