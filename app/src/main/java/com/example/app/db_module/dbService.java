package com.example.app.db_module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.db_module.db_interface.CompanionRepo;
import com.example.app.db_module.db_interface.CompanionSpotRepo;
import com.example.app.db_module.db_interface.CompanionStampRepo;
import com.example.app.db_module.db_interface.InsertImageRepo;
import com.example.app.db_module.db_interface.RoutesRepo;
import com.example.app.db_module.db_interface.TransportationRepo;
import com.example.app.db_module.tables.Companion;
import com.example.app.db_module.tables.CompanionSpot;
import com.example.app.db_module.tables.CompanionStamp;
import com.example.app.db_module.tables.InsertImage;
import com.example.app.db_module.tables.Routes;
import com.example.app.db_module.tables.Transportation;

@Service
public class dbService {

    //コンストラクタインジェクション
    private CompanionRepo companionRepo;
    private CompanionSpotRepo companionSpotRepo;
    private CompanionStampRepo companionStampRepo;
    private InsertImageRepo insertImageRepo;
    private TransportationRepo transportationRepo;
    private RoutesRepo routesRepo;

    @Autowired
    public dbService(CompanionRepo companionRepo,CompanionSpotRepo companionSpotRepo
        ,CompanionStampRepo companionStampRepo,InsertImageRepo insertImageRepo
        ,TransportationRepo transportationRepo,RoutesRepo routesRepo) {

        this.companionRepo = companionRepo;
        this.companionSpotRepo = companionSpotRepo;
        this.companionStampRepo = companionStampRepo;
        this.insertImageRepo = insertImageRepo;
        this.transportationRepo = transportationRepo;
        this.routesRepo = routesRepo;
    }


    //追加メゾット一覧
    //Companion Table
    public Long createCompanion(Companion companion) {
        try{
            Companion c = companionRepo.save(companion);
            return c.getCompanionId();
        }catch(Exception e){
            return null;
        }
    }

    //CompanionSpot Table
    public boolean createSpot(CompanionSpot companionSpot) {
        try{
            companionSpotRepo.save(companionSpot);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //CompanionStamp Table
    public boolean createStamp(CompanionStamp companionStamp) {
        try{
            companionStampRepo.save(companionStamp);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //InsertImage Table
    public boolean createImg(InsertImage insertImage) {
        try{
            insertImageRepo.save(insertImage);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //Transportation Table
    public boolean createTransportation(Transportation transportation) {
        try{
            transportationRepo.save(transportation);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //Transportation Table
    public boolean createRoutes(Routes routes){
        try{
            routesRepo.save(routes);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //削除メゾット一覧(引数は主キー)
    //Companion Table
    public boolean deleteCompanion(Long companion_id) {
        Companion existingcCompanion = companionRepo.findById(companion_id).orElse(null);
        if(existingcCompanion == null) return false;
        else{
            companionRepo.delete(existingcCompanion);
            return true;
        }
    }

    //CompanionSpot Table
    public boolean deleteCompanionSpot(Long spot_id) {
        CompanionSpot existingcCompanionSpot = companionSpotRepo.findById(spot_id).orElse(null);
        if(existingcCompanionSpot == null) return false;
        else{
            companionSpotRepo.delete(existingcCompanionSpot);
            return true;
        }
    }

    //CompanionStamp Table
    public boolean deleteCompanionStamp(Long stamp_id) {
        CompanionStamp existingcCompanionStamp = companionStampRepo.findById(stamp_id).orElse(null);
        if(existingcCompanionStamp == null) return false;
        else{
            companionStampRepo.delete(existingcCompanionStamp);
            return true;
        }
    }

    //InsertStamp Table
    public boolean deleteInsertStamp(Long img_id) {
        InsertImage existinginsertImage = insertImageRepo.findById(img_id).orElse(null);
        if(existinginsertImage == null) return false;
        else{
            insertImageRepo.delete(existinginsertImage);
            return true;
        }
    }

    //Transportation Table
        public boolean deleteTransportation(Long trans_id) {
        Transportation existingcTransportation = transportationRepo.findById(trans_id).orElse(null);
        if(existingcTransportation == null) return false;
        else{
            transportationRepo.delete(existingcTransportation);
            return true;
        }
    }

    //取得メゾット一覧
    //Find by companionId
    //Companion table
    public Companion readCompanions(Long companionId) {
        return companionRepo.findById(companionId).orElse(null);
    }

    //CompanionStop table
    public List<CompanionSpot> readCompanionSpots(Long companionId) {
        return companionSpotRepo.findByCompanion_CompanionId(companionId);
    }

    //CompanionStamp table
    public List<CompanionStamp> readCompanionStamps(Long companionId) {
        return companionStampRepo.findByCompanion_CompanionId(companionId);
    }

    //InsertImage table
    public List<InsertImage> readInsertImages(Long companionId) {
        return insertImageRepo.findByCompanion_CompanionId(companionId);
    }

    //Transportation table
    public List<Transportation> readTransportations(Long companionId) {
        return transportationRepo.findByCompanion_CompanionId(companionId);
    }

    //Routes table
    public List<Routes> readRoutes(Long companionId) {
        return routesRepo.findByCompanion_CompanionId(companionId);
    }

    //更新メゾット一覧(引数はcompanion_id)

}
