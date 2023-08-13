package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; // 追加
import org.springframework.web.bind.annotation.RestController; // 追加

@SpringBootApplication
@RestController // 追加

public class AppApplication {
	
	@RequestMapping("/")  // 追加
	public String home() { // 追加
		return "Hello World"; // 追加
	} // 追加
	@RequestMapping("/api")  // 追加
	public String api() { // 追加
		return "Hello"; // 追加
	} // 追加
	@GetMapping("/api/data")
	@CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<String> getData() {
        String data = "spring boot 起動！";
        return ResponseEntity.ok(data);
    }

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
