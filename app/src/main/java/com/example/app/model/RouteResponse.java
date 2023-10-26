package com.example.app.model;

public class RouteResponse {
    private double distance;
    private int duration;
    
    // getters, setters
    public double getDistance() {
        return distance;
    }
    public void setDistance(double d) {
        this.distance = d;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}