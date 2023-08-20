package com.example.app.db_module.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//CompanionSpot Table
@Entity
public class CompanionSpot {

    //column list
    @Id
    @Column(name = "spot_id" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long spot_id;

    @ManyToOne
    @JoinColumn(name = "companion_id" , nullable = false)
    private Companion companion_id;

    @Column(name = "spot_url" , length = 256)
    private String spot_url;

    @Column(name = "spot_lon" , nullable = false)
    private float spot_lon;

    @Column(name = "spot_lat" , nullable = false)
    private float spot_lat;

    @Column(name = "spot_name" , length = 256)
    private String spot_name;

    //getter,setter
    public Long getSpot_id() {
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
    public void setSpot_id(Long spot_id) {
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
