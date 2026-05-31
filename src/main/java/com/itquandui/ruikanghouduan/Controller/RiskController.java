package com.itquandui.ruikanghouduan.Controller;

import com.itquandui.ruikanghouduan.Service.RiskService;
import com.itquandui.ruikanghouduan.model.RiskEvaluateRequest;
import com.itquandui.ruikanghouduan.model.RiskEvaluateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @PostMapping("/evaluate")
    public RiskEvaluateResponse evaluate(@RequestBody RiskEvaluateRequest req) {
        return riskService.evaluate(req);
    }
}
