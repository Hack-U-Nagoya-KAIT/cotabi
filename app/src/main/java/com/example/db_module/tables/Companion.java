package com.example.db_module.tables;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Companion Table
@Entity
public class Companion {
    @Id
    @NotNull
    private UUID companion_id;

    private String companion_title;
    @NotNull
    private int design_num;

    public UUID getCompanion_id() {
        return companion_id;
    }
    public String getCompanion_title() {
        return companion_title;
    }
    public int getDesign_num() {
        return design_num;
    }
    public void setCompanion_id(UUID companion_id) {
        this.companion_id = companion_id;
    }
    public void setCompanion_title(String companion_title) {
        this.companion_title = companion_title;
    }
    public void setDesign_num(int design_num) {
        this.design_num = design_num;
    }
}
