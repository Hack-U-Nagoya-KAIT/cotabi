package com.example.app.db_module.tables;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Companion Table
@Entity
public class Companion {

    //column list
    @Column(name = "companionId" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long companionId;

    @JsonBackReference
    @OneToMany(mappedBy = "companion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanionSpot> companionSpotsList;

    @Column(name = "companionTitle")
    private String companionTitle;

    @Column(name = "designNum" , nullable = false , length = 256)
    private int designNum;

    //getter,setter
    public Long getCompanionId() {
        return companionId;
    }

    public void setCompanionId(Long companionId) {
        this.companionId = companionId;
    }

    public List<CompanionSpot> getCompanionSpotsList() {
        return companionSpotsList;
    }

    public void setCompanionSpotsList(List<CompanionSpot> companionSpotsList) {
        this.companionSpotsList = companionSpotsList;
    }

    public String getCompanionTitle() {
        return companionTitle;
    }

    public void setCompanionTitle(String companionTitle) {
        this.companionTitle = companionTitle;
    }

    public int getDesignNum() {
        return designNum;
    }

    public void setDesignNum(int designNum) {
        this.designNum = designNum;
    }
}
