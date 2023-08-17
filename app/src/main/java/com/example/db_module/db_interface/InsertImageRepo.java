package com.example.db_module.db_interface;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.db_module.tables.InsertImage;

public interface InsertImageRepo extends JpaRepository<InsertImage, UUID>{
    
}
