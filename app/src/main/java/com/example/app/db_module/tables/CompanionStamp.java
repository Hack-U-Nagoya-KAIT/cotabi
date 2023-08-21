package com.example.app.db_module.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//CompanionStamp Table
@Entity
public class CompanionStamp {

    //column list
    @Id
    @Column(name = "companionStamp" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companionStamp;

    @ManyToOne
    @JoinColumn(name = "companionId")
    @JsonBackReference
    private Companion companion;

    @Column(name = "stampLon" , nullable = false)
    private float stampLon;

    @Column(name = "stampLat" , nullable = false)
    private float stampLat;

    //getter,setter
    public Long getCompanionStamp() {
        return companionStamp;
    }

    public void setCompanionStamp(Long companionStamp) {
        this.companionStamp = companionStamp;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public float getStampLon() {
        return stampLon;
    }

    public void setStampLon(float stampLon) {
        this.stampLon = stampLon;
    }

    public float getStampLat() {
        return stampLat;
    }

    public void setStampLat(float stampLat) {
        this.stampLat = stampLat;
    }
}
