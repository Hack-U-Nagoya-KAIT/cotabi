package com.example.app.model;

public class YolpData {
    String name;
    double lat;
    double lon;
    String tag;
    String address;

    public YolpData(String name, double lat, double lon, String tag, String address) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.tag = tag;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    
}
