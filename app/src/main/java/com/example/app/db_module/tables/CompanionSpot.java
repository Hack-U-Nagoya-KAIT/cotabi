package com.example.app.db_module.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @Column(name = "spotId" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long spotId;

    @ManyToOne
    @JoinColumn(name = "companionId" , nullable = false)
    @JsonBackReference
    private Companion companion;

    @Column(name = "spotAddress" , length = 256)
    private String spotAddress;

    @Column(name = "spotLon" , nullable = false)
    private float spotLon;

    @Column(name = "spotLat" , nullable = false)
    private float spotLat;

    @Column(name = "spotName" , length = 256)
    private String spotName;

    //getter,setter
    public Long getSpotId() {
        return spotId;
    }

    public void setSpotId(Long spotId) {
        this.spotId = spotId;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public float getSpotLon() {
        return spotLon;
    }

    public void setSpotLon(float spotLon) {
        this.spotLon = spotLon;
    }

    public float getSpotLat() {
        return spotLat;
    }

    public void setSpotLat(float spotLat) {
        this.spotLat = spotLat;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotAddress() {
        return spotAddress;
    }

    public void setSpotAddress(String spotAddress) {
        this.spotAddress = spotAddress;
    }

}
