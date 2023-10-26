package com.example.app.db_module.db_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.db_module.tables.Routes;

public interface RoutesRepo extends JpaRepository<Routes, Long> {
    List<Routes>findByCompanion_CompanionId(Long companion_id);
}
