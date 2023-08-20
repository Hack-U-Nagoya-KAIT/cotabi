package com.example.app.db_module.tables;



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
    @Column(name = "trans_id" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trans_id;

    @ManyToOne
    @JoinColumn(name = "companion_id" , nullable = false)
    private Companion companion_id;

    @Column(name = "transportation_name" , nullable = false , length = 256)
    private String transportation_name;

    @Column(name = "departure_time")
    private String departure_time;

    @Column(name = "arrival_time")
    private String arrival_time;

    @Column(name = "departure_place" , nullable = false , length = 256)
    private String departure_place;

    @Column(name = "arrival_place" , nullable = false , length = 256)
    private String arrival_place;

    @Column(name = "fee")
    private int fee;

    //getter,setter
    public Long getTrans_id() {
        return trans_id;
    }
    public Companion getCompanion_id() {
        return companion_id;
    }
    public String getTransportation_name() {
        return transportation_name;
    }
    String getDeparture_time() {
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
    public void setTrans_id(Long trans_id) {
        this.trans_id = trans_id;
    }
    public void setCompanion_id(Companion companion_id) {
        this.companion_id = companion_id;
    }
    public void setTransportation_name(String transportation_name) {
        this.transportation_name = transportation_name;
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
