package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestRebel;

import java.util.*;
import java.util.stream.Collectors;

public class BancoRebel {
    private static List<Rebel> rebels = new ArrayList<>();

    public void addRebel(Rebel rebel){
        BancoRebel.rebels.add(rebel);
    }
    public int getQuantityRebelAndTraitor(){
        return rebels.size();
    }
    public List<Rebel> getRebels(){
         new ArrayList<>();
        List<Rebel> notTraitors = rebels.stream().filter(rebel -> !rebel.isTraitor()).collect(Collectors.toList());
        return notTraitors;
    }

    public Rebel getDetailsRebel(UUID id) throws Exception {
        Optional<Rebel> resultRebel =
                BancoRebel.rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id)).findAny();
        if(resultRebel.isPresent()){
            return resultRebel.get();
        } else {
            throw new Exception("Rebel not found!");
        }
    }

    public Rebel updateRebel(UUID id, RequestRebel requestRebel) throws Exception {
        BancoRebel.rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id))
                .forEach(rebel -> {
                    rebel.setName(requestRebel.getName());
                    rebel.setAge(requestRebel.getAge());
                    rebel.setGender(Gender.valueOf(requestRebel.getGender()));
                    Localization localization = new Localization(requestRebel.getLatitude(), requestRebel.getLongitude());
                    rebel.setLocalization(localization);
                });
        return getDetailsRebel(id);
    }
    public Rebel updateRebelLocalization(UUID id, double latitude, double longitude) throws Exception {
        BancoRebel.rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id))
                .forEach(rebel -> {
                    rebel.setLocalization(new Localization(latitude, longitude));
                });
        return getDetailsRebel(id);
    }
    public void removeRebel(UUID id) throws Exception {
        Rebel rebel = getDetailsRebel(id);
        BancoRebel.rebels.remove(rebel);
    }
}
