package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.controller;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.ItemRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trade")
public class TradeControler {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/trade")
    public boolean changeItems(
            @PathVariable UUID rebelAId,
            @PathVariable List<ItemRebel> itemsA,
            @PathVariable UUID rebelBId,
            @PathVariable List<ItemRebel> itemsB
    ) throws Exception {
        return tradeService.changeItems(rebelAId, itemsA, rebelBId, itemsB);
    }
}
