package com.example.app.db_module.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Companion Table
@Entity
public class Companion {

    //column list
    @Id
    @Column(name = "companion_id" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companion_id;

    @Column(name = "companion_title")
    private String companion_title;

    @Column(name = "design_num" , nullable = false , length = 256)
    private int design_num;

    //getter,setter
    public Long getCompanion_id() {
        return companion_id;
    }
    public String getCompanion_title() {
        return companion_title;
    }
    public int getDesign_num() {
        return design_num;
    }
    public void setCompanion_id(Long companion_id) {
        this.companion_id = companion_id;
    }
    public void setCompanion_title(String companion_title) {
        this.companion_title = companion_title;
    }
    public void setDesign_num(int design_num) {
        this.design_num = design_num;
    }
}
