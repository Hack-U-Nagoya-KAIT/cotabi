package com.example.db_module.tables;

import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//InsertImage Table
@Entity
public class InsertImage {
    @Id
    @NotNull
    private UUID img_id;

    @ManyToOne
    @JoinColumn(name = "companion_id")
    @NotNull
    private Companion companion_id;

    @NotNull
    private String img;
    @NotNull
    private float img_lon;
    @NotNull
    private float img_lat;

    public UUID getImg_id() {
        return img_id;
    }
    public Companion getCompanion_id() {
        return companion_id;
    }
    public String getImg() {
        return img;
    }
    public float getImg_lon() {
        return img_lon;
    }
    public float getImg_lat() {
        return img_lat;
    }
    public void setImg_id(UUID img_id) {
        this.img_id = img_id;
    }
    public void setCompanion_id(Companion companion_id) {
        this.companion_id = companion_id;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public void setImg_lon(float img_lon) {
        this.img_lon = img_lon;
    }
    public void setImg_lat(float img_lat) {
        this.img_lat = img_lat;
    }
}
