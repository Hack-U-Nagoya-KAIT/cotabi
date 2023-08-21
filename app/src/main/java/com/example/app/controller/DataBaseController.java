package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.db_module.dbService;
import com.example.app.db_module.tables.Companion;
import com.example.app.db_module.tables.CompanionSpot;
import com.example.app.db_module.tables.CompanionStamp;
import com.example.app.db_module.tables.InsertImage;
import com.example.app.db_module.tables.Transportation;


//This is database controller.
@RestController
@RequestMapping("/api/db")
public class DataBaseController {
    private dbService service;

    @Autowired
    public DataBaseController(dbService service){
        this.service = service;
    }

    //CREATE NEW DATA FOR Companion TABLE
    //戻り値 boolean型true/false
    @PostMapping("/create/comp")
    public boolean createcomp(@RequestBody Companion companion) {
        return service.createCompanion(companion);
    }

    //CREATE NEW DATA FOR Companion_Spot TABLE
    //戻り値 boolean型true/false
    @PostMapping("/create/spot")
    public boolean createSpot(@RequestBody CompanionSpot companionSpot) {
    return service.createSpot(companionSpot);
    }

    //CREATE NEW DATA FOR Companion_Stamp TABLE
    //戻り値 boolean型true/false
    @PostMapping("/create/stamp")
    public boolean createStamp(@RequestBody CompanionStamp companionStamp) {
        return service.createStamp(companionStamp);
    }

    //CREATE NEW DATA FOR Insert_Image TABLE
    //戻り値 boolean型true/false
    @PostMapping("/create/img")
    public boolean createImg(@RequestBody InsertImage insertImage) {
        return service.createImg(insertImage);
    }
    

    //CREATE NEW DATA FOR Transportation TABLE
    //戻り値 boolean型true/false
    @PostMapping("/create/trans")
    public boolean createTrans(@RequestBody Transportation transportation) {
        return service.createTransportation(transportation);
    }


    //READ Companion TABLE DATA FROM FOREIGN KEY
    //戻り値 Companion型
    @GetMapping("/read/comp/{companionId}")
    public Companion findCompanionById(Long companion_id) {
        return service.readCompanions(companion_id);
    }

    //READ CompanionSpot TABLE DATA FROM FOREIGN KEY
    //戻り値 List<Companion>型
    @GetMapping("/read/spot/{companionId}")
    public List<CompanionSpot> findCompanionSpotById(@PathVariable Long companionId) {
        return service.readCompanionSpots(companionId);
    }

    //READ CompanionStamp TABLE DATA FROM FOREIGN KEY
    //戻り値 List<Companion>型
    @GetMapping("/read/stamp/{companionId}")
    public List<CompanionStamp> findCompanionStampById(@PathVariable Long companionId) {
        return service.readCompanionStamps(companionId);
    }

    //READ InsertImage TABLE DATA FROM FOREIGN KEY
    //戻り値 List<Companion>型
    @GetMapping("/read/img/{companionId}")
    public List<InsertImage> findInsertImageById(@PathVariable Long companion_id) {
        return service.readInsertImages(companion_id);
    }

    //READ Transportation TABLE DATA FROM FOREIGN KEY
    //戻り値 List<Companion>型
    @GetMapping("/read/trans/{companionId}")
    public List<Transportation> findTransportationById(@PathVariable Long companion_id) {
        return service.readTransportations(companion_id);
    }
}
