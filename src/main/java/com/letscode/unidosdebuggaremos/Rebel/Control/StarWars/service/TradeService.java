package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.RebelControlStarWarsApplication;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Item;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.ItemRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TradeService {

    public boolean changeItems(UUID rebelAId, List<Item> itemsA, UUID rebelBId, List<Item> itemsB) throws Exception {
        Rebel rebelA = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelAId);
        Rebel rebelB = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelBId);
        if (rebelA.isTraitor() || rebelB.isTraitor() || existItems(rebelA.getItems(), itemsB) || existItems(rebelB.getItems(), itemsA)) {
            return false;
        }
        tradeItems(rebelA.getItems(), rebelB.getItems(), itemsA);
        tradeItems(rebelB.getItems(), rebelA.getItems(), itemsB);
        return true;
    }
    public void tradeItems(List<Item> buyerItems, List<Item>sellerItems, List<Item> items) {
        for (Item item : items) {
            buyItem(buyerItems,item);
            sellItem(sellerItems,item);
        }
    }
    public void sellItem(List<Item>rebelItems, Item item) {
        Item itemRebel = findItem(rebelItems, item);
        int qnt = itemRebel.getQuantity();
        itemRebel.setQuantity(qnt-item.getQuantity());
    }
    public void buyItem(List<Item>rebelItems, Item item) {
        Item itemRebel = findItem(rebelItems, item);
        int qnt = itemRebel.getQuantity();
        itemRebel.setQuantity(qnt+item.getQuantity());
    }
    public Item findItem(List<Item>rebelItems, Item item) {
        List<Item> itemRebels = rebelItems.stream().filter(ir -> ir.getItem() == item.getItem()).collect(Collectors.toList());
        return itemRebels.get(0);
    }
    public boolean existItems(List<Item>rebelItems, List<Item>items) {
        for (Item item : items) {
            Item itemRebel = findItem(rebelItems, item);
            if(itemRebel == null || (itemRebel.getItem() == item.getItem() && itemRebel.getQuantity() < item.getQuantity())) return false;
        }
        return true;
    }
}
