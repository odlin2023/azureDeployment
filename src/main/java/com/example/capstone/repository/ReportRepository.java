package com.example.capstone.repository;

import com.example.capstone.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // Add custom queries if needed
}

