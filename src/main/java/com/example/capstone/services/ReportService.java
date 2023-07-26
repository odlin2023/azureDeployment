package com.example.capstone.services;


import com.example.capstone.model.Report;
import com.example.capstone.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    public Iterable<Report> getAllReports() {
        return reportRepository.findAll();
    }
}

