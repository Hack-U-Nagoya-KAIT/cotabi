package com.example.app.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ChatGptServiceTag {

    public static String generateTravelSuggestion(String taglist,String concept) {
        RestTemplate restTemplate = new RestTemplate();

        String model = "gpt-3.5-turbo";
        String dataList = taglist;
        //String dataList = "水族館,遊園地,ラーメン屋,イタリアンレストラン";
        String apiKey = "";//ここにapiKeyを入れて
        String prompt = "以下の注意とデータリストを元に、コンセプト:" + concept + "にあったデータを選んでください。\n 注意:\n- データリストから2つ選ぶ\n- ','でデータを区切る\n- 余計な文をつけない\n- \"\u30C7\u30D1\u30FC\u30C8,\u30C6\u30FC\u30DE\u30D1\u30FC\u30AF,\u30D3\u30EA\u30E4\u30FC\u30C9\"形式で出力\nデータリスト：" + dataList;
        String chatGptApiEndpoint = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are the assistant who selects the data for the concept.");

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

        return response;
    }
}