package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.controller;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.ResponseRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.ItemRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service.RebelService;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rebel")
public class RebelController {

    @Autowired
    private RebelService rebelService;

    @GetMapping
    public List<ResponseRebel> rebels(){
        return ResponseRebel.toResponse(rebelService.getRebels());
    }

    @PostMapping
    public ResponseEntity<ResponseRebel> registerRebel(
            @RequestBody @Valid RequestRebel requestRebel,
            UriComponentsBuilder uriComponentsBuilder
    ){
        Rebel rebel = rebelService.registerRebel(requestRebel);
        URI uri = uriComponentsBuilder.path("/rebel/{id}").buildAndExpand(rebel.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseRebel(rebel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseRebel> getDetailsRebel(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(new ResponseRebel(rebelService.getDetailsRebel(id)));
    }

    @PostMapping("/reportAsTraitor/{id}")
    public boolean reportAsTraitor(
            @PathVariable UUID rebelId
    ) throws Exception {
        return rebelService.addBetrayal(rebelId);
    }

    @GetMapping("/isTraitor/{id}")
    public boolean isTraitor(
            @PathVariable UUID rebelId
    ) throws Exception {
        return rebelService.isTraitor(rebelId);
    }

}
