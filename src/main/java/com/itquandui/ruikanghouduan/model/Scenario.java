package com.itquandui.ruikanghouduan.model;

public class Scenario {
    private String code;
    private String title;
    private String description;
    private String script;

    public Scenario() {
    }

    public Scenario(String code, String title, String description, String script) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.script = script;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
