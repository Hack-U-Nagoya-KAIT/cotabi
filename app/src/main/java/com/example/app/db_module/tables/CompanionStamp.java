package com.example.app.db_module.tables;

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
    @Column(name = "companion_stamp" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companion_stamp;

    @ManyToOne
    @JoinColumn(name = "companion_id" , nullable = false)
    private Companion companion_id;

    @Column(name = "stamp_lon" , nullable = false)
    private float stamp_lon;

    @Column(name = "stamp_lat" , nullable = false)
    private float stamp_lat;

    //getter,setter
    public Long getCompanion_stamp() {
        return companion_stamp;
    }
    public Companion getCompanion_id() {
        return companion_id;
    }
    public float getStamp_lon() {
        return stamp_lon;
    }
    public float getStamp_lat() {
        return stamp_lat;
    }
    public void setCompanion_stamp(Long companion_stamp) {
        this.companion_stamp = companion_stamp;
    }
    public void setCompanion_id(Companion companion_id) {
        this.companion_id = companion_id;
    }
    public void setStamp_lon(float stamp_lon) {
        this.stamp_lon = stamp_lon;
    }
    public void setStamp_lat(float stamp_lat) {
        this.stamp_lat = stamp_lat;
    }
}
