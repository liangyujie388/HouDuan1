package com.itquandui.ruikanghouduan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiSmokeTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void scenarios_list_ok() throws Exception {
        mockMvc.perform(get("/api/scenarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void risk_evaluate_ok() throws Exception {
        String body = "{\"url\":\"http://t.cn/xxxx\",\"content\":\"需要保证金解冻\"}";
        mockMvc.perform(post("/api/risk/evaluate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.level").exists())
                .andExpect(jsonPath("$.score").exists())
                .andExpect(jsonPath("$.suggestion").exists());
    }

    @Test
    void reports_create_and_list_ok() throws Exception {
        String body = "{\"type\":\"phishing_link\",\"evidence\":\"http://xxbank-verify.com\",\"reporter\":\"demo\"}";
        mockMvc.perform(post("/api/reports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        mockMvc.perform(get("/api/reports"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
