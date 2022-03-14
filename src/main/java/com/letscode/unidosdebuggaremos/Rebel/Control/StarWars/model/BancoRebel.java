package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestRebel;

import java.util.*;

public class BancoRebel {
    private static List<Rebel> rebels = new ArrayList<>();

    public void addRebel(Rebel rebel){
        BancoRebel.rebels.add(rebel);
    }

    public List<Rebel> getRebels(){
        return BancoRebel.rebels;
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
    public Rebel updateRebelLocalization(UUID id, Localization newLocalization) throws Exception {
        BancoRebel.rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id))
                .forEach(rebel -> {
                    rebel.setLocalization(newLocalization);
                });
        return getDetailsRebel(id);
    }
    public void deletaRebel(UUID id) throws Exception {
        Rebel rebel = getDetailsRebel(id);
        BancoRebel.rebels.remove(rebel);
    }
}
