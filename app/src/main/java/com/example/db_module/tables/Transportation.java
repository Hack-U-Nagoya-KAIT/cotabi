package com.example.db_module.tables;


import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Transportation Table
@Entity
public class Transportation {
    @Id
    @NotNull
    private UUID trans_id;

    @ManyToOne
    @JoinColumn(name = "companion_id")
    @NotNull
    private Companion companion_id;

    @NotNull
    private String transportation_name;
    private String eventDateTime;
    private String departure_time;
    private String arrival_time;
    @NotNull
    private String departure_place;
    @NotNull
    private String arrival_place;
    private int fee;

    public UUID getTrans_id() {
        return trans_id;
    }
    public Companion getCompanion_id() {
        return companion_id;
    }
    public String getTransportation_name() {
        return transportation_name;
    }
    public String getEventDateTime() {
        return eventDateTime;
    }
    public String getDeparture_time() {
        return departure_time;
    }
    public String getArrival_time() {
        return arrival_time;
    }
    public String getDeparture_place() {
        return departure_place;
    }
    public String getArrival_place() {
        return arrival_place;
    }
    public int getFee() {
        return fee;
    }
    public void setTrans_id(UUID trans_id) {
        this.trans_id = trans_id;
    }
    public void setCompanion_id(Companion companion_id) {
        this.companion_id = companion_id;
    }
    public void setTransportation_name(String transportation_name) {
        this.transportation_name = transportation_name;
    }
    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }
    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }
    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }
    public void setArrival_place(String arrival_place) {
        this.arrival_place = arrival_place;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }
}
