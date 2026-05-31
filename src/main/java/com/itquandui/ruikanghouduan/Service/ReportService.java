package com.itquandui.ruikanghouduan.Service;

import com.itquandui.ruikanghouduan.Repository.ReportRepository;
import com.itquandui.ruikanghouduan.model.Report;
import com.itquandui.ruikanghouduan.model.ReportCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report create(ReportCreateRequest req) {
        if (req == null || req.getType() == null || req.getType().isBlank()) {
            throw new IllegalArgumentException("type不能为空");
        }
        if (req.getEvidence() == null || req.getEvidence().isBlank()) {
            throw new IllegalArgumentException("evidence不能为空");
        }

        Report report = new Report();
        report.setType(req.getType());
        report.setEvidence(req.getEvidence());
        report.setReporter(req.getReporter());
        report.setCreatedAt(Instant.now());
        return reportRepository.save(report);
    }

    public List<Report> list() {
        return reportRepository.findAll();
    }
}
