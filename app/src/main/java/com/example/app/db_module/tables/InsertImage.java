package com.example.app.db_module.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//InsertImage Table
@Entity
public class InsertImage {

    //column list
    @Id
    @Column(name = "img_id" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long img_id;

    @ManyToOne
    @JoinColumn(name = "companion_id" , nullable = false)
    private Companion companion_id;

    @Column(name = "img" , nullable = false ,length = 256)
    private String img;

    @Column(name = "img_lon" , nullable = false)
    private float img_lon;

    @Column(name = "img_lat" , nullable = false)
    private float img_lat;

    //getter,setter
    public Long getImg_id() {
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
    public void setImg_id(Long img_id) {
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
