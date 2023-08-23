package com.example.app.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ChatGptService {

    public static void generateTravelSuggestion(String taglist) {
        RestTemplate restTemplate = new RestTemplate();

        String model = "gpt-3.5-turbo";
        String dataList = taglist;
        //String dataList = "水族館,遊園地,ラーメン屋,イタリアンレストラン";
        String apiKey = "";//ここにapiKeyを入れて
        String concept = "お寺参り";
        String prompt = "以下のデータリストを元に、コンセプト:" + concept + "に沿った、旅行ルートを箇条書きで提案してください。コンセプトに沿わないプランはいくつか消してください。\n" + dataList;
        String chatGptApiEndpoint = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are a helpful assistant.");

        JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", prompt);

        JSONArray messagesArray = new JSONArray();
        messagesArray.put(systemMessage);
        messagesArray.put(userMessage);

        JSONObject requestBodyObject = new JSONObject();
        requestBodyObject.put("messages", messagesArray);
        requestBodyObject.put("model", model);

        String requestBody = requestBodyObject.toString();

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        String response = restTemplate.postForObject(chatGptApiEndpoint, entity, String.class);

        System.out.println(response);
    }
}