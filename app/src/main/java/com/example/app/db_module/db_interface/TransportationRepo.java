package com.example.app.db_module.db_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.db_module.tables.Transportation;

@Repository
public interface TransportationRepo extends JpaRepository<Transportation, Long> {
    List<Transportation>findByCompanion_CompanionId(Long companion_id);
}
