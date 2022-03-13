package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.RebelControlStarWarsApplication;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RebelService {
    Random random = new Random();

    public Rebel registerRebel(RequestRebel requestRebel){
        List<Rebel> rebels = new ArrayList<>();
        Localization localization = new Localization(requestRebel.getLocalization().getLatitude(), requestRebel.getLocalization().getLongitude());
//        List<ItemRebel> items = genNewRebelList();
        List<Item> items = new ArrayList<>();
        requestRebel.getItems().forEach(item -> {
            items.add(new Item(new ItemRebel(item.getItemName()), item.getItemQuantity()));
        });
        Rebel rebel = new Rebel(UUID.randomUUID(), requestRebel.getName(), requestRebel.getAge(),
                Gender.valueOf(requestRebel.getGender()),
                localization, items, 0);
        rebels.add(rebel);
        RebelControlStarWarsApplication.bancoRebel.addRebel(rebel);
        return rebel;
    }

//    public List<ItemRebel> genNewRebelList() {
//        List<ItemRebel> items = new ArrayList<>();
//        items.add(new ItemRebel(new Item("weapon", 4 ),ThreadLocalRandom.current().nextInt(0, 12 + 1)));
//        items.add(new ItemRebel(new Item("ammunition", 3 ), ThreadLocalRandom.current().nextInt(0, 12 + 1)));
//        items.add(new ItemRebel(new Item("water", 2 ), ThreadLocalRandom.current().nextInt(0, 12 + 1)));
//        items.add(new ItemRebel(new Item("food", 1 ), ThreadLocalRandom.current().nextInt(0, 12 + 1)));
//        return items;
//    }

    public List<Rebel> getRebels(){
        return RebelControlStarWarsApplication.bancoRebel.getRebels();
    }

    public Rebel getDetailsRebel(UUID id) throws Exception {
        return RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(id);
    }
    public Rebel updateRebel(UUID id, RequestRebel requestRebel) throws Exception {
        return RebelControlStarWarsApplication.bancoRebel.updateRebel(id, requestRebel);
    }
    public boolean addBetrayal(UUID rebelId) throws Exception {
        Rebel rebel = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelId);
        return rebel.reportBetrayal();
    }
    public boolean isTraitor(UUID rebelId) throws Exception {
        Rebel rebel = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelId);
        return rebel.isTraitor();
    }
}
