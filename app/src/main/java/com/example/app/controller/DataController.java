package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/con")
public class DataController {

    @RequestMapping("/api")  // 追加
	public String home() { // 追加
		return "Hello World"; // 追加
	} // 追加

    @GetMapping("/api/data")
    public ResponseEntity<String> getData() {
        String data = "spring boot 起動！";
        return ResponseEntity.ok(data);
    }
}
