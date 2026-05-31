package com.itquandui.ruikanghouduan.model;

import java.util.List;

public class RiskEvaluateResponse {
    private RiskLevel level;
    private int score;
    private List<String> hitRules;
    private String suggestion;

    public RiskEvaluateResponse() {
    }

    public RiskEvaluateResponse(RiskLevel level, int score, List<String> hitRules, String suggestion) {
        this.level = level;
        this.score = score;
        this.hitRules = hitRules;
        this.suggestion = suggestion;
    }

    public RiskLevel getLevel() {
        return level;
    }

    public void setLevel(RiskLevel level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getHitRules() {
        return hitRules;
    }

    public void setHitRules(List<String> hitRules) {
        this.hitRules = hitRules;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
