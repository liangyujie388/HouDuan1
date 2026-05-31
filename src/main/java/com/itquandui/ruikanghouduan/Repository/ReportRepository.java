package com.itquandui.ruikanghouduan.Repository;

import com.itquandui.ruikanghouduan.model.Report;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReportRepository {
    private final ConcurrentHashMap<Long, Report> db = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(0);

    public Report save(Report report) {
        if (report.getId() == null) {
            report.setId(idGen.incrementAndGet());
        }
        db.put(report.getId(), report);
        return report;
    }

    public Optional<Report> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<Report> findAll() {
        List<Report> list = new ArrayList<>(db.values());
        list.sort(Comparator.comparing(Report::getCreatedAt).reversed());
        return list;
    }
}
