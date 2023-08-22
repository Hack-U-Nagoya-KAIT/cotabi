package com.example.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.LocationRequest;
@RestController
public class LocationController {
    @RequestMapping("/api")
    public String hello() { // 追加
        return "Hello World"; // 追加
    } // 追加
    @PostMapping("/api/location")
    public String postLocation(@RequestBody LocationRequest request) {
        double latitude = request.getLatitude();
        double longitude = request.getLongitude();

        // ここで必要な処理を行う（データベースへの保存など）
        String yolpData =Yolp.getYolpData(latitude, longitude);

        return "位置情報が受信されました。"+latitude+" "+longitude+yolpData;
    }
}