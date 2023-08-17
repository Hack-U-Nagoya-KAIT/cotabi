package com.example.db_module.db_interface;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.db_module.tables.Companion;

public interface CompanionRepo extends JpaRepository<Companion, UUID>  {
    
}

