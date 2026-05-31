package com.itquandui.ruikanghouduan.model;

import java.time.Instant;

public class Report {
    private Long id;
    private String type;
    private String evidence;
    private String reporter;
    private Instant createdAt;

    public Report() {
    }

    public Report(Long id, String type, String evidence, String reporter, Instant createdAt) {
        this.id = id;
        this.type = type;
        this.evidence = evidence;
        this.reporter = reporter;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
