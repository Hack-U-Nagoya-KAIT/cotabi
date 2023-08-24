package com.example.app.model;

public class RouteResponse {
    private String distance;
    private String duration;
    private String polyline;

    // getters, setters
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getPolyline() {
        return polyline;
    }
    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }
}
