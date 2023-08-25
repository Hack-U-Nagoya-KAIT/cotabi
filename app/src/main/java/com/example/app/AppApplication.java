package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.app.model.RouteRequest;
import com.example.app.model.RouteResponse;

@SpringBootApplication
public class AppApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
			RestTemplate restTemplate = new RestTemplate();
			String apiUrl = "http://localhost:8080/calculate-route"; // Spring BootアプリケーションのエンドポイントURL
			RouteRequest request = new RouteRequest();
			// request に必要なデータを設定
			request.setOriginLat(35.48668272234388);
			request.setOriginLng(139.3426752758823);
			request.setDestLat(35.46584463015975);
			request.setDestLng(139.6224030823321);


			ResponseEntity<RouteResponse> responseEntity = restTemplate.postForEntity(apiUrl, request, RouteResponse.class);
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				RouteResponse response = responseEntity.getBody();
				// response を処理
				System.out.println(response.getDuration());
			} else {
				// エラーハンドリング
			}
	}

}
