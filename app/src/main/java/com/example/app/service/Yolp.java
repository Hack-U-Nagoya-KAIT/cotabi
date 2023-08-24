package com.example.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Yolp {

        // @Value("${yolp.api.key}")
        private static String apiKey;

        // public Yolp(@Value("${yolp.api.key}") String apiKey) {
        //         // Yolp.apiKey = apiKey;
        // }

        public static String getYolpData(double latitude, double longitude, double radius) {
                String baseUrl = "https://map.yahooapis.jp/search/local/V1/localSearch";

                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response_1 = restTemplate.getForEntity(
                                baseUrl + "?appid=" + apiKey + "&device=mobile&lat=" + latitude + "&lon=" + longitude
                                                + "&dist="
                                                + radius + "&results=20&sort=rating&detail=string&gc=0302003&output=json",
                                // "&dist=10&results=20&sort=geo&detail=string&gc=0204001&gc=0302003&gc=0303&gc=0305"
                                String.class);

                ResponseEntity<String> response_2 = restTemplate.getForEntity(
                                baseUrl + "?appid=" + apiKey + "&device=mobile&lat=" + latitude + "&lon=" + longitude
                                                + "&dist="
                                                + radius + "&results=20&sort=rating&detail=string&gc=0204001&output=json",
                                // "&dist=10&results=20&sort=geo&detail=string&gc=0204001&gc=0302003&gc=0303&gc=0305"
                                String.class);

                ResponseEntity<String> response_3 = restTemplate.getForEntity(
                                baseUrl + "?appid=" + apiKey + "&device=mobile&lat=" + latitude + "&lon=" + longitude
                                                + "&dist="
                                                + radius + "&results=20&sort=rating&detail=string&gc=030&output=json3",
                                // "&dist=10&results=20&sort=geo&detail=string&gc=0204001&gc=0302003&gc=0303&gc=0305"
                                String.class);

                ResponseEntity<String> response_4 = restTemplate.getForEntity(
                                baseUrl + "?appid=" + apiKey + "&device=mobile&lat=" + latitude + "&lon=" + longitude
                                                + "&dist=5"
                                                + radius + "results=10&sort=rating&detail=string&gc=0305&output=json",
                                // "&dist=10&results=20&sort=geo&detail=string&gc=0204001&gc=0302003&gc=0303&gc=0305"
                                String.class);

                ResponseEntity<String> response_5 = restTemplate.getForEntity(
                                baseUrl + "?appid=" + apiKey + "&device=mobile&lat=" + latitude + "&lon=" + longitude
                                                + "&dist=5"
                                                + radius + "results=10&sort=rating&detail=string&gc=0424001&output=json",
                                // "&dist=10&results=20&sort=geo&detail=string&gc=0204001&gc=0302003&gc=0303&gc=0305"
                                String.class);

                ResponseEntity<String> response_6 = restTemplate.getForEntity(
                                baseUrl + "?appid=" + apiKey + "&device=mobile&lat=" + latitude + "&lon=" + longitude
                                                + "&dist=5"
                                                + radius + "results=10&sort=rating&detail=string&gc=0424002&output=json",
                                // "&dist=10&results=20&sort=geo&detail=string&gc=0204001&gc=0302003&gc=0303&gc=0305"
                                String.class);

                String response1Body = response_1.getBody();
                String response2Body = response_2.getBody();
                String response3Body = response_3.getBody();
                String response4Body = response_4.getBody();
                String response5Body = response_5.getBody();
                String response6Body = response_6.getBody();
                System.out.println(response1Body);
                System.out.println(response2Body);
                System.out.println(response3Body);
                System.out.println(response4Body);
                System.out.println(response5Body);
                System.out.println(response6Body);
                System.out.println("範囲" + radius);
                
                return response1Body;
                //String taglist = XmlParsing.xml(response1Body, response2Body, response3Body, response4Body, response5Body,
                                //response6Body);
                //return taglist;
        }
}