package com.example.app.db_module.db_interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.db_module.tables.InsertImage;

@Repository
public interface InsertImageRepo extends JpaRepository<InsertImage, Long>{
    
}
