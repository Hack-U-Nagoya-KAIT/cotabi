package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.ChatGPTRequest;
import com.example.app.model.ChatGPTResponse;

@RestController
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/ask-gpt")
    public ChatGPTResponse askGPT(@RequestBody ChatGPTRequest request) {
        return chatGPTService.sendRequestToGPT(request);
    }
}