package com.example.db_module.tables;

import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//CompanionSpot Table
@Entity
public class CompanionSpot {
    @Id
    @NotNull
    private UUID spot_id;
    
    @ManyToOne
    @JoinColumn(name = "companion_id")
    @NotNull
    private Companion companion_id;

    private String spot_url;
    @NotNull
    private float spot_lon;
    @NotNull
    private float spot_lat;
    @NotNull
    private String spot_name;

    public UUID getSpot_id() {
        return spot_id;
    }
    public Companion getCompanion_id() {
        return companion_id;
    }
    public String getSpot_url() {
        return spot_url;
    }
    public float getSpot_lon() {
        return spot_lon;
    }
    public float getSpot_lat() {
        return spot_lat;
    }
    public String getSpot_name() {
        return spot_name;
    }
    public void setSpot_id(UUID spot_id) {
        this.spot_id = spot_id;
    }
    public void setCompanion_id(Companion companion_id) {
        this.companion_id = companion_id;
    }
    public void setSpot_url(String spot_url) {
        this.spot_url = spot_url;
    }
    public void setSpot_lon(float spot_lon) {
        this.spot_lon = spot_lon;
    }
    public void setSpot_lat(float spot_lat) {
        this.spot_lat = spot_lat;
    }
    public void setSpot_name(String spot_name) {
        this.spot_name = spot_name;
    }
}
