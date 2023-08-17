package com.example.db_module;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.db_module.db_interface.CompanionRepo;
import com.example.db_module.db_interface.CompanionSpotRepo;
import com.example.db_module.db_interface.CompanionStampRepo;
import com.example.db_module.db_interface.InsertImageRepo;
import com.example.db_module.db_interface.TransportationRepo;
import com.example.db_module.tables.Companion;
import com.example.db_module.tables.CompanionSpot;
import com.example.db_module.tables.CompanionStamp;
import com.example.db_module.tables.InsertImage;
import com.example.db_module.tables.Transportation;


@Service
public class dbService {

    @Autowired
    private CompanionRepo companionRepo;
    private CompanionSpotRepo companionSpotRepo;
    private CompanionStampRepo companionStampRepo;
    private InsertImageRepo insertImageRepo;
    private TransportationRepo transportationRepo;

    //登録メゾット一覧
    //Companion Table create
    public boolean createCompanion(Companion companion) {
        try{
            companionRepo.save(companion);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //CompanionSpot Table create
    public boolean createSpot(CompanionSpot companionSpot) {
        try{
            companionSpotRepo.save(companionSpot);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //CompanionStamp Table create
    public boolean createStamp(CompanionStamp companionStamp) {
        try{
            companionStampRepo.save(companionStamp);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //InsertImage Table create
    public boolean createImg(InsertImage insertImage) {
        try{
            insertImageRepo.save(insertImage);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //Transportation Table create
        public boolean createTransportation(Transportation transportation) {
        try{
            transportationRepo.save(transportation);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //削除メゾット一覧
    //Companion Table delete(引数は主キー)
    public boolean deleteCompanion(UUID companion_id) {
        Companion existingcCompanion = companionRepo.findById(companion_id).orElse(null);
        if(existingcCompanion == null) return false;
        else{
            companionRepo.delete(existingcCompanion);
            return true;
        }
    }

    //CompanionSpot Table delete(引数は主キー)
    public boolean deleteCompanionSpot(UUID spot_id) {
        CompanionSpot existingcCompanionSpot = companionSpotRepo.findById(spot_id).orElse(null);
        if(existingcCompanionSpot == null) return false;
        else{
            companionSpotRepo.delete(existingcCompanionSpot);
            return true;
        }
    }

    //CompanionStamp Table delete(引数は主キー)
    public boolean deleteCompanionStamp(UUID stamp_id) {
        CompanionStamp existingcCompanionStamp = companionStampRepo.findById(stamp_id).orElse(null);
        if(existingcCompanionStamp == null) return false;
        else{
            companionStampRepo.delete(existingcCompanionStamp);
            return true;
        }
    }

    //InsertStamp Table delete(引数は主キー)
    public boolean deleteInsertStamp(UUID img_id) {
        InsertImage existinginsertImage = insertImageRepo.findById(img_id).orElse(null);
        if(existinginsertImage == null) return false;
        else{
            insertImageRepo.delete(existinginsertImage);
            return true;
        }
    }

    //Transportation Table delete(引数は主キー)
        public boolean deleteTransportation(UUID trans_id) {
        Transportation existingcTransportation = transportationRepo.findById(trans_id).orElse(null);
        if(existingcTransportation == null) return false;
        else{
            transportationRepo.delete(existingcTransportation);
            return true;
        }
    }


}
