// package com.example.app.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// @Service
// public class ChatGptService {

//     @Value("${chatgpt.api.key}")
//     private static String apiKey;  // ChatGPT APIのAPIキー

//     public ChatGptService(@Value("${chatgpt.api.key}") String apiKey) {
//         ChatGptService.apiKey = apiKey;
//     }

//     public static void sendChatGptRequest(List<YolpData> dataList) {
//         String apiUrl = "https://api.openai.com/v1/chat/completions";  // ChatGPT APIのエンドポイント

//         RestTemplate restTemplate = new RestTemplate();

//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.set("Authorization", "Bearer " + apiKey);

//         String requestBody = "{\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},{\"role\": \"user\", \"content\": \"Tell me a joke\"}]}";

//         HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

//         ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);

//         if (response.getStatusCode().is2xxSuccessful()) {
//             System.out.println(response.getBody());
//         } else {
//             System.out.println("Error occurred: " + response);
//         }
//     }
// }