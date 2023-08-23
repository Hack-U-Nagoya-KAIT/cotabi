package com.example.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService {

    

    @Value("${chatgpt.api.key}") // ChatGPT APIのAPIキー
    private String apiKey;

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String dataList="水族館";
        String chatGptApiEndpoint="https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        String requestBody = "{\"data\": \"" + dataList + "\", \"prompt\": \"" + prompt + "\"}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        String response = restTemplate.postForObject(chatGptApiEndpoint, entity, String.class);

        return response;
    }
}

//     public String getChatGptResponse(YolpData dataList) {
//         RestTemplate restTemplate = new RestTemplate();

//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.set("Authorization", "Bearer " + apiKey);

//         String requestBody = "{\"data\": \"" + dataList + "\", \"prompt\": \"Tell me a joke\"}";

//         HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

//         String response = restTemplate.postForObject(chatGptApiEndpoint, entity, String.class);

//         System.out.println(response);

//         return response;
//     }
// }
