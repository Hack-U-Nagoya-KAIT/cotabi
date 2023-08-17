package com.example.db_module.tables;

import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//CompanionStamp Table
@Entity
public class CompanionStamp {
    @Id
    @NotNull
    private UUID companion_stamp;

    @ManyToOne
    @JoinColumn(name = "companion_id")
    @NotNull
    private Companion companion_id;

    @NotNull
    private float stamp_lon;
    @NotNull
    private float stamp_lat;

    public UUID getCompanion_stamp() {
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
    public void setCompanion_stamp(UUID companion_stamp) {
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
