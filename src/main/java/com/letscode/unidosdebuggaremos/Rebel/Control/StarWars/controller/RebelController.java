package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.controller;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.RebelControlStarWarsApplication;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestLocalization;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.GeneralReport;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.ResponseRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service.RebelService;
//import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service.TradeService;
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

    @PatchMapping("/report-as-traitor/{id}")
    public ResponseEntity<String> reportAsTraitor(
            @PathVariable UUID id
    ) throws Exception {
                rebelService.addBetrayal(id);
        return ResponseEntity.ok("Reported");
    }

//    @GetMapping("/isTraitor/{id}")
//    public boolean isTraitor(
//            @PathVariable UUID id
//    ) throws Exception {
//        return rebelService.isTraitor(id);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseRebel> updateRebel(@PathVariable UUID id, @RequestBody RequestRebel requestRebel) throws Exception {
        Rebel rebel = rebelService.updateRebel(id, requestRebel);
        return ResponseEntity.ok(new ResponseRebel(rebel));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseRebel> updateLocalizationRebel(@PathVariable UUID id, @RequestBody RequestLocalization requestLocalization) throws Exception {
        Rebel rebel = rebelService.updateRebelLocalization(id, requestLocalization.getLatitude(), requestLocalization.getLongitude());
        return ResponseEntity.ok(new ResponseRebel(rebel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeRebel(@PathVariable UUID id) throws Exception {
        RebelControlStarWarsApplication.bancoRebel.removeRebel(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/general-report")
    public ResponseEntity<GeneralReport> generalReport(){
    GeneralReport generalReport = rebelService.getGeneralReport();
    return ResponseEntity.ok(generalReport);
    }



}
