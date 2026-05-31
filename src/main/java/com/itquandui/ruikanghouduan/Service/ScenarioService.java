package com.itquandui.ruikanghouduan.Service;

import com.itquandui.ruikanghouduan.model.Scenario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScenarioService {

    private final Map<String, Scenario> scenarios = new LinkedHashMap<>();

    public ScenarioService() {
        scenarios.put("order_refund", new Scenario(
                "order_refund",
                "刷单返利",
                "小额返利诱导大额垫付，借口“解冻/保证金”。",
                "【诈骗分子】先做个小任务，返你10元\n【你】我试试\n【诈骗分子】现在加大金额才能提现吗？需要先垫付500解冻……\n【你】（此时应提高警惕：不要转账，不要垫付，及时止损并举报）"
        ));
        scenarios.put("game_trade", new Scenario(
                "game_trade",
                "游戏交易",
                "低价皮肤/账号，诱导跳转外链或仿冒担保平台。",
                "【诈骗分子】平台担保，点击链接付款\n【你】链接看起来像官方\n【诈骗分子】先付押金才能发货……\n【你】（核验域名、不要私下转账、走官方渠道）"
        ));
        scenarios.put("impersonate_police", new Scenario(
                "impersonate_police",
                "冒充公检法",
                "恐吓涉案，要求保密、屏幕共享、转入安全账户。",
                "【诈骗分子】你涉嫌洗钱，立刻配合\n【你】我需要怎么做\n【诈骗分子】下载会议软件共享屏幕，转入安全账户……\n【你】（公检法不会线上办案/不会要转账；立即挂断并拨打110核实）"
        ));
    }

    public List<Scenario> list() {
        return new ArrayList<>(scenarios.values());
    }

    public Scenario get(String code) {
        return scenarios.get(code);
    }
}
