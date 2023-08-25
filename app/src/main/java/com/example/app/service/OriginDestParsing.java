package com.example.app.service;

import java.util.List;

import com.example.app.model.RouteRequest;
import com.example.app.model.YolpData;

public class OriginDestParsing {
    public static RouteRequest Parsing(List<YolpData> dataList, String spot, double latitude, double longitude) {
        // RouteRequestオブジェクト作成
        RouteRequest dest = new RouteRequest();
        // 指定したspot名に対応するlatとlonを取得する
        dest.setOriginLat(latitude);
        dest.setOriginLng(longitude);
        
        for (YolpData data : dataList) {
            
            if (data.getName().equals(spot)) {
                dest.setDestLat(data.getLat());
                dest.setDestLng(data.getLon());
            }
        }
        return dest;
    }
}
