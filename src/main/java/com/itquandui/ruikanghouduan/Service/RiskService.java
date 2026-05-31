package com.itquandui.ruikanghouduan.Service;

import com.itquandui.ruikanghouduan.model.RiskEvaluateRequest;
import com.itquandui.ruikanghouduan.model.RiskEvaluateResponse;
import com.itquandui.ruikanghouduan.model.RiskLevel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class RiskService {

    public RiskEvaluateResponse evaluate(RiskEvaluateRequest req) {
        String url = safeLower(req == null ? null : req.getUrl());
        String content = safeLower(req == null ? null : req.getContent());

        int score = 0;
        List<String> hit = new ArrayList<>();

        if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            // ok
        }
        if (url != null && url.startsWith("http://")) {
            score += 10;
            hit.add("URL使用http明文");
        }
        if (url != null && (url.contains("verify") || url.contains("secure") || url.contains("login"))) {
            score += 10;
            hit.add("URL包含诱导性关键字(verify/secure/login)");
        }
        if (url != null && (url.contains("bit.ly") || url.contains("t.cn") || url.contains("short"))) {
            score += 15;
            hit.add("疑似短链");
        }

        if (containsAny(content, "解冻", "保证金", "垫付", "刷流水", "返利")) {
            score += 30;
            hit.add("资金压力/垫付类话术");
        }
        if (containsAny(content, "公检法", "涉案", "通缉", "保密", "安全账户", "屏幕共享")) {
            score += 40;
            hit.add("冒充公检法/恐吓类话术");
        }
        if (containsAny(content, "低价", "内部", "专属", "限时", "官方担保", "跳转链接")) {
            score += 20;
            hit.add("低价/引流外链类话术");
        }

        RiskLevel level;
        if (score >= 60) level = RiskLevel.HIGH;
        else if (score >= 30) level = RiskLevel.MEDIUM;
        else level = RiskLevel.LOW;

        String suggestion = buildSuggestion(level);
        return new RiskEvaluateResponse(level, score, hit, suggestion);
    }

    private static String buildSuggestion(RiskLevel level) {
        return switch (level) {
            case HIGH -> "高风险：请立即停止转账/下载/屏幕共享；不要点击外链；保留证据并一键举报。";
            case MEDIUM -> "中风险：建议核验对方身份与链接域名；拒绝任何垫付/保证金；必要时向官方渠道核实。";
            case LOW -> "低风险：未命中明显高危规则，但仍建议不泄露验证码/密码，不轻信转账要求。";
        };
    }

    private static boolean containsAny(String text, String... keywords) {
        if (text == null || text.isBlank()) return false;
        for (String k : keywords) {
            if (k != null && !k.isBlank() && text.contains(k.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    private static String safeLower(String s) {
        if (s == null) return null;
        String t = s.trim();
        if (t.isEmpty()) return "";
        return t.toLowerCase(Locale.ROOT);
    }
}
