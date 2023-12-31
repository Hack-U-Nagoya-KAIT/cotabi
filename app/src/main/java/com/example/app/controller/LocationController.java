package com.example.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.SetDistance.SetDistance;
import com.example.app.model.LocationRequest;
import com.example.app.model.RouteRequest;
import com.example.app.model.RouteResponse;
import com.example.app.model.YolpData;
import com.example.app.service.ChatGptServiceTag;
import com.example.app.service.ContentNameParsing;
import com.example.app.service.HttpdbPost;
import com.example.app.service.JsonParsing;
import com.example.app.service.ListSplit;
import com.example.app.service.OriginDestParsing;
import com.example.app.service.RandomName;
import com.example.app.service.RouteService;
import com.example.app.service.RoutesParsing;
import com.example.app.service.Yolp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class LocationController {

    @RequestMapping("/api")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/api/location")
    public ResponseEntity<Map<String, Object>> postLocation(@RequestBody LocationRequest request) throws JsonMappingException, JsonProcessingException {
        Map<String, Object> response = new HashMap<>();
        try {
            double latitude = request.getLatitude();
            double longitude = request.getLongitude();
            // int time = request.getTime();
            int budget = request.getBudget();
            String concept = request.getConcept();
            

            SetDistance setDistance = new SetDistance();

            double distance = setDistance.GenerateDistance(budget);

            // Call Yolop
            // ここで必要な処理を行う（データベースへの保存など）
            List<YolpData> dataList= Yolp.getYolpData(latitude, longitude, distance);
            String taglist = ListSplit.Split(dataList);
            System.out.println(taglist);
            // Call Gpt
            String json=ChatGptServiceTag.generateTravelSuggestion(taglist,concept);
            System.out.println(json);
            String content = JsonParsing.json(json);
            System.out.println(content);
            String result = ContentNameParsing.NameParsing(dataList,content);
            System.out.println(result);
            String spot = RandomName.random(result);
            System.out.println(spot);
            RouteRequest origindest = OriginDestParsing.Parsing(dataList,spot,latitude,longitude);
            System.out.println(origindest.getDestLat());
            System.out.println(origindest.getDestLng());
            System.out.println(origindest.getOriginLat());
            System.out.println(origindest.getOriginLng());
            String route = RouteService.RoutesAPI(origindest);
            System.out.println(route);
            RouteResponse distdura = RoutesParsing.Parsing(route);
            System.out.println(distdura.getDistance());
            System.out.println(distdura.getDuration());
        

            //add data
            HttpdbPost httpdbPost=new HttpdbPost();
            Long id = httpdbPost.CC();
            httpdbPost.cSpot(id, origindest.getDestLng(), origindest.getDestLat(), spot, origindest.getAddress());
            httpdbPost.cRoutes(id,distdura.getDistance(),distdura.getDuration());

            response.put("success", true);
            response.put("message", "位置情報とデータが正常に受信されました。");
            response.put("id",id);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "サーバーでエラーが発生しました。");
            return ResponseEntity.badRequest().body(response);
        }
    }
}