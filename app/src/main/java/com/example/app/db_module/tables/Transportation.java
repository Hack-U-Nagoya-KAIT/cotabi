package com.example.app.db_module.tables;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Transportation Table
@Entity
public class Transportation {

    //column list
    @Id
    @Column(name = "transId" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transId;

    @ManyToOne
    @JoinColumn(name = "companionId")
    @JsonBackReference
    private Companion companion;

    @Column(name = "transportationName" , nullable = false , length = 256)
    private String transportation_name;

    @Column(name = "departureTime")
    private String departure_time;

    @Column(name = "arrivalTime")
    private String arrival_time;

    @Column(name = "departurePlace" , nullable = false , length = 256)
    private String departure_place;

    @Column(name = "arrivalPlace" , nullable = false , length = 256)
    private String arrival_place;

    @Column(name = "fee")
    private int fee;

    //getter,setter
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public String getTransportation_name() {
        return transportation_name;
    }

    public void setTransportation_name(String transportation_name) {
        this.transportation_name = transportation_name;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public String getArrival_place() {
        return arrival_place;
    }

    public void setArrival_place(String arrival_place) {
        this.arrival_place = arrival_place;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
