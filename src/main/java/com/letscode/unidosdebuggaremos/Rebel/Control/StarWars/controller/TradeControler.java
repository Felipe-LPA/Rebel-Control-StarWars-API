package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.controller;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestTrade;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Item;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trade")
public class TradeControler {

    @Autowired
    private TradeService tradeService;

    @PatchMapping()
    public boolean changeItems(
            @RequestBody RequestTrade requestTrade
            ) throws Exception {
        return tradeService.changeItems(requestTrade.getRebelIdA(),requestTrade.getRebelItensA(), requestTrade.getRebelIdB(), requestTrade.getRebelItensB());
    }
}
