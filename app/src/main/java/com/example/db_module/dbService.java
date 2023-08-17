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

    //登録
    public boolean createCompanion(Companion companion) {
        try{
            companionRepo.save(companion);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean createSpot(CompanionSpot companionSpot) {
        try{
            companionSpotRepo.save(companionSpot);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean createStamp(CompanionStamp companionStamp) {
        try{
            companionStampRepo.save(companionStamp);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean createImg(InsertImage insertImage) {
        try{
            insertImageRepo.save(insertImage);
            return true;
        }catch(Exception e){
            return false;
        }
    }

        public boolean createTransportation(Transportation transportation) {
        try{
            transportationRepo.save(transportation);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //更新
    public Companion getCompanionById(UUID companion_id,){
        return companionRepo.findBy(companion_id).orElse(null);
    }

    //削除
    public boolean deleteCompanion(UUID companion_id) {
        Companion existingcCompanion = companionRepo.findById(companion_id).orElse(null);
        if(existingcCompanion == null) return false;
        else{
            companionRepo.delete(existingcCompanion);
            return true;
        }
    }
        public boolean deleteCompanionSpot(UUID spot_id) {
        Companion existingcCompanionSpot = companionRepo.findById(spot_id).orElse(null);
        if(existingcCompanionSpot == null) return false;
        else{
            companionRepo.delete(existingcCompanionSpot);
            return true;
        }
    }
        public boolean deleteInsertImage(UUID stamp_id) {
        Companion existingcCompanionStamp = companionRepo.findById(stamp_id).orElse(null);
        if(existingcCompanionStamp == null) return false;
        else{
            companionRepo.delete(existingcCompanionStamp);
            return true;
        }
    }
        public boolean deleteCompanionStamp(UUID stamp_id) {
        Companion existingcCompanionStamp = companionRepo.findById(stamp_id).orElse(null);
        if(existingcCompanionStamp == null) return false;
        else{
            companionRepo.delete(existingcCompanionStamp);
            return true;
        }
    }


}
