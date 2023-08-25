package com.example.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.SetDistance.SetDistance;
import com.example.app.model.LocationRequest;
import com.example.app.service.Yolp;

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
        //int time = request.getTime();
        //int budget = request.getBudget();
        //String concept = request.getConcept();

        SetDistance setDistance = new SetDistance();
        request.setBudget(2050);
        int budget= request.getBudget();
        
        double distance = setDistance.GenerateDistance(budget);

        // ここで必要な処理を行う（データベースへの保存など）
        Yolp.getYolpData(latitude , longitude , distance);

        return "位置情報が受信されました。"+latitude+" "+longitude;
    }
}