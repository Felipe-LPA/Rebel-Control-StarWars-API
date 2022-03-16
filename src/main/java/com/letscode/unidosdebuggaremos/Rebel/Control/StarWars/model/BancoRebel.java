package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions.NotFoundException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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

    public Rebel getDetailsRebel(UUID id) throws NotFoundException {
        Optional<Rebel> resultRebel =
                BancoRebel.rebels.stream().filter(rebel -> Objects.equals(rebel.getId(),id)).findAny();
        if(resultRebel.isPresent()){
            return resultRebel.get();
        } else {
            throw new NotFoundException("Rebel not found!");
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
    public GeneralReport getGeneralReport(){
        List<Rebel> notTraitors = getRebels();
        int Totalregistered = getQuantityRebelAndTraitor();
        String percentegeRebel = (notTraitors.size() * 100 / Totalregistered) + "%" ;
        String percentegeTraitors = (((Totalregistered - notTraitors.size()) * 100) / Totalregistered) + "%";;
        AvgItemsQuantity avgItemsQuantity = getAvgItemsQuantity(notTraitors);
        int lostPoints = getLostPoints();

        return new GeneralReport(percentegeRebel,percentegeTraitors, avgItemsQuantity, lostPoints);
    }
    private AvgItemsQuantity getAvgItemsQuantity(List<Rebel> notTraitors){
        AvgItemsQuantity avgItemsQuantity = new AvgItemsQuantity(0,0,0,0);
        notTraitors.forEach(rebel -> {
            rebel.getItems().forEach(item -> {
                String itemName = item.getItem().getItem();
                int quantity = item.getQuantity();
                if(Objects.equals(itemName, "weapon")){
                    avgItemsQuantity.setAvgWeapon(quantity);
                }
                if(Objects.equals(itemName, "ammunition")){
                    avgItemsQuantity.setAvgAmmunition(quantity);
                }
                if(Objects.equals(itemName, "water")){
                    avgItemsQuantity.setAvgWater(quantity);
                }
                if(Objects.equals(itemName, "food")){
                    avgItemsQuantity.setAvgFood(quantity);
                }
            });
        });
        avgItemsQuantity.setAvg(notTraitors.size());
        return avgItemsQuantity;
    }
    private int getLostPoints(){
        AtomicInteger traitorItens = new AtomicInteger();
        rebels.forEach(rebel -> {
            if (rebel.isTraitor()){
            rebel.getItems().forEach(item -> {
                traitorItens.addAndGet(item.getQuantity() * item.getItem().getValue());
            });
            }
        });
        return traitorItens.get();
    }
}
