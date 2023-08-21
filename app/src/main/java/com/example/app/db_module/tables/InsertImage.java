package com.example.app.db_module.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @Column(name = "imgId" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imgId;

    @ManyToOne
    @JoinColumn(name = "companionId")
    @JsonBackReference
    private Companion companion;

    @Column(name = "img" , nullable = false ,length = 256)
    private String img;

    @Column(name = "imgLon" , nullable = false)
    private float imgLon;

    @Column(name = "imgLat" , nullable = false)
    private float imgLat;

    //getter,setter
    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getImgLon() {
        return imgLon;
    }

    public void setImgLon(float imgLon) {
        this.imgLon = imgLon;
    }

    public float getImgLat() {
        return imgLat;
    }

    public void setImgLat(float imgLat) {
        this.imgLat = imgLat;
    }

}
