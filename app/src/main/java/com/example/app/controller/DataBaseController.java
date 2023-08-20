package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/test")
public class DataBaseController {
    private dbService service;

    @Autowired
    public DataBaseController(dbService service){
        this.service = service;
    }

    @RequestMapping("/db")  // 追加
	public String pp() { // 追加
		return "Hello World"; // 追加
	} // 追加

    //しおり格納メゾット
    //戻り値 boolean型true/false
    @PostMapping("/create/comp")
    public boolean createcomp(@RequestBody Companion companion) {
        return service.createCompanion(companion);
    }

    //しおりスポットの格納メゾット
    //戻り値 boolean型true/false
    @PostMapping("/create/spot")
    public boolean createSpot(@RequestBody CreateCompanionSpotRequest createcCompanionSpotRequest) {
        return service.createSpot(createcCompanionSpotRequest.getCompanion_id() ,
        createcCompanionSpotRequest.getTransportation());
    }

    //リクエスト用の型生成(引数)
    class CreateCompanionSpotRequest {
        private Long companion_id;
        private CompanionSpot companionSpot;
        
        public Long getCompanion_id() {
            return companion_id;
        }
        public CompanionSpot getTransportation() {
            return companionSpot;
        }
    }

    //しおりスタンプの格納メゾット
    //戻り値 boolean型true/false
    @PostMapping("/create/stamp")
    public boolean createStamp(@RequestBody CreateCompanionStampRequest companionStampRequest) {
        return service.createStamp(companionStampRequest.getCompanion_id() , companionStampRequest.getCompanionStamp());
    }

    //リクエスト用の型生成(引数)
    class CreateCompanionStampRequest {
        private Long companion_id;
        private CompanionStamp companionStamp;

        public Long getCompanion_id() {
            return companion_id;
        }
        public CompanionStamp getCompanionStamp() {
            return companionStamp;
        }
    }


    //しおり画像の格納メゾット
    //戻り値 boolean型true/false
    @PostMapping("/create/img")
    public boolean createImg(@RequestBody CreateInsertImageRequest createInsertImageRequest) {
        return service.createImg(createInsertImageRequest.getCompanion_id(), createInsertImageRequest.getImage());
    }
    
    //リクエスト用の型生成(引数)
    class CreateInsertImageRequest {
        private Long companion_id;
        private InsertImage image;

        public Long getCompanion_id() {
            return companion_id;
        }
        public InsertImage getImage() {
            return image;
        }
    }

    //しおり交通機関の格納メゾット
    //戻り値 boolean型true/false
    @PostMapping("/create/trans")
    public boolean createTrans(@RequestBody CreateTransportationRequest createTransportationRequest) {
        return service.createTransportation(createTransportationRequest.getCompanion_id() ,
        createTransportationRequest.getTransportation());
    }

    //リクエスト用の型生成(引数)
    class CreateTransportationRequest {
        private Long companion_id;
        private Transportation transportation;

        public Long getCompanion_id() {
            return companion_id;
        }
        public Transportation getTransportation() {
            return transportation;
        }
    }
}
