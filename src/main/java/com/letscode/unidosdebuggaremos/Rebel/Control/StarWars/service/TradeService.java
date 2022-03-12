package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.RebelControlStarWarsApplication;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.ItemRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TradeService {

    public boolean changeItems(UUID rebelAId, List<ItemRebel> itemsA, UUID rebelBId, List<ItemRebel> itemsB) throws Exception {
        Rebel rebelA = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelAId);
        Rebel rebelB = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelBId);
        if (rebelA.isTraitor() || rebelB.isTraitor() || existItems(rebelA.getItems(), itemsB) || existItems(rebelB.getItems(), itemsA)) {
            return false;
        }
        tradeItems(rebelA.getItems(), rebelB.getItems(), itemsA);
        tradeItems(rebelB.getItems(), rebelA.getItems(), itemsB);
        return true;
    }
    public void tradeItems(List<ItemRebel> buyerItems, List<ItemRebel>sellerItems, List<ItemRebel> items) {
        for (ItemRebel item : items) {
            buyItem(buyerItems,item);
            sellItem(sellerItems,item);
        }
    }
    public void sellItem(List<ItemRebel>rebelItems, ItemRebel item) {
        ItemRebel itemRebel = findItem(rebelItems, item);
        int qnt = itemRebel.getQuantity();
        itemRebel.setQuantity(qnt-item.getQuantity());
    }
    public void buyItem(List<ItemRebel>rebelItems, ItemRebel item) {
        ItemRebel itemRebel = findItem(rebelItems, item);
        int qnt = itemRebel.getQuantity();
        itemRebel.setQuantity(qnt+item.getQuantity());
    }
    public ItemRebel findItem(List<ItemRebel>rebelItems, ItemRebel item) {
        List<ItemRebel> itemRebels = rebelItems.stream().filter(ir -> ir.getItem().getName() == item.getItem().getName()).collect(Collectors.toList());
        return itemRebels.get(0);
    }
    public boolean existItems(List<ItemRebel>rebelItems, List<ItemRebel>items) {
        boolean check = true;
        for (ItemRebel item : items) {
            ItemRebel itemRebel = findItem(rebelItems, item);
            if(itemRebel == null || (itemRebel.getItem().getName() == item.getItem().getName()
                    && itemRebel.getQuantity() < item.getQuantity())) {
                check = false;
                break;
            }
        }
        return check;
    }
}
