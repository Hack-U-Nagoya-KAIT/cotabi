package com.example.app.db_module.db_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.db_module.tables.CompanionSpot;

@Repository
public interface CompanionSpotRepo extends JpaRepository<CompanionSpot, Long> {
    List<CompanionSpot>findByCompanion_CompanionId(Long companionId);
}
