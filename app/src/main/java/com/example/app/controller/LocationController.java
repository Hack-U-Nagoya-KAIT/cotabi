package com.example.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

import com.example.app.SetDistance.SetDistance;
import com.example.app.model.LocationRequest;
import com.example.app.service.Yolp;

@RestController
public class LocationController {
    
    @RequestMapping("/api")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/api/location")
    public ResponseEntity<Map<String, Object>> postLocation(@RequestBody LocationRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            int time = request.getTime();
            int budget = request.getBudget();
            String concept = request.getConcept();
            double latitude = request.getLatitude();
            double longitude = request.getLongitude();

            System.out.println(time);
            System.out.println(budget);
            System.out.println(concept);
            System.out.println(latitude);
            System.out.println(longitude);
            
            // こちらでデータベースの保存や他の処理を行います

            response.put("success", true);
            response.put("message", "位置情報とデータが正常に受信されました。");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "サーバーでエラーが発生しました。");
            return ResponseEntity.badRequest().body(response);
        }
    }
}




// package com.example.app.controller;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.app.SetDistance.SetDistance;
// import com.example.app.model.LocationRequest;
// import com.example.app.service.Yolp;
// @RestController
// public class LocationController {
//     @RequestMapping("/api")
//     public String hello() { // 追加
//         return "Hello World"; // 追加
//     } // 追加
//     @PostMapping("/api/location")
//     public String postLocation(@RequestBody LocationRequest request) {
//         // double latitude = request.getLatitude();
//         // double longitude = request.getLongitude();
//         int time = request.getTime();
//         int budget = request.getBudget();
//         String concept = request.getConcept();
//         System.out.println(time);
//         System.out.println(budget);
//         System.out.println(concept);
//         // SetDistance setDistance = new SetDistance();
//         // request.setBudget(2050);
//         // int budget= request.getBudget();
        
//         // double distance = setDistance.GenerateDistance(budget);

//         // // ここで必要な処理を行う（データベースへの保存など）
//         // Yolp.getYolpData(latitude , longitude , distance);

//         return "位置情報が受信されました。";
//         // +latitude+" "+longitude;
//     }
// }



