package com.example.app.model;

public class RouteRequest {
    private double originLat;
    private double originLng;
    private double destLat;
    private double destLng;

    // getters, setters
    public double getOriginLat() {
        return originLat;
    }
    public void setOriginLat(double originLat) {
        this.originLat = originLat;
    }
    public double getOriginLng() {
        return originLng;
    }
    public void setOriginLng(double originLng) {
        this.originLng = originLng;
    }
    public double getDestLat() {
        return destLat;
    }
    public void setDestLat(double destLat) {
        this.destLat = destLat;
    }
    public double getDestLng() {
        return destLng;
    }
    public void setDestLng(double destLng) {
        this.destLng = destLng;
    }
}
