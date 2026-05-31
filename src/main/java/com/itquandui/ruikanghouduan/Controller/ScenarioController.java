package com.itquandui.ruikanghouduan.Controller;

import com.itquandui.ruikanghouduan.Service.ScenarioService;
import com.itquandui.ruikanghouduan.model.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @GetMapping
    public List<Scenario> list() {
        return scenarioService.list();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Scenario> get(@PathVariable String code) {
        Scenario scenario = scenarioService.get(code);
        if (scenario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scenario);
    }
}
