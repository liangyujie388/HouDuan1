package com.itquandui.ruikanghouduan.Controller;

import com.itquandui.ruikanghouduan.Service.ReportService;
import com.itquandui.ruikanghouduan.model.Report;
import com.itquandui.ruikanghouduan.model.ReportCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ReportCreateRequest req) {
        try {
            Report report = reportService.create(req);
            return ResponseEntity.ok(report);
        } catch (IllegalArgumentException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", ex.getMessage());
            return ResponseEntity.badRequest().body(body);
        }
    }

    @GetMapping
    public List<Report> list() {
        return reportService.list();
    }
}
