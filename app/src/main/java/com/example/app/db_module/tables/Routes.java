package com.example.app.db_module.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Routes {
        //column list
        @Column(name = "routeId" , nullable = false , unique = true)
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Long routeId;

        @ManyToOne
        @JoinColumn(name = "companionId" , nullable = false)
        @JsonBackReference
        private Companion companion;

        @Column(name = "distance")
        private double distance;

        @Column(name = "duration")
        private int duration;

        public Long getRouteId() {
            return routeId;
        }

        public void setRouteId(Long routeId) {
            this.routeId = routeId;
        }

        public Companion getCompanion() {
            return companion;
        }

        public void setCompanion(Companion companion) {
            this.companion = companion;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
}
