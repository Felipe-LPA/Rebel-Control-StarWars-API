package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.service;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.RebelControlStarWarsApplication;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestItem;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions.NotFoundException;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions.TradeException;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Item;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.ItemRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TradeService {
    public void changeItems(UUID rebelAId, List<RequestItem> requestItemsA, UUID rebelBId, List<RequestItem> requestItemsB) throws TradeException, NotFoundException {
        Rebel rebelA = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelAId);
        Rebel rebelB = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelBId);

        List<Item> itemsA = new ArrayList<>();
        requestItemsA.forEach(item -> {
            itemsA.add(new Item(new ItemRebel(item.getItemName()), item.getItemQuantity()));
        });

        List<Item> itemsB = new ArrayList<>();
        requestItemsB.forEach(item -> {
            itemsB.add(new Item(new ItemRebel(item.getItemName()), item.getItemQuantity()));
        });

        compatibleItensToTrade(itemsA, itemsB);
        existItems(rebelA.getItems(), itemsB);
        existItems(rebelB.getItems(), itemsA);

        tradeItems(rebelA.getItems(), rebelB.getItems(), itemsA);
        tradeItems(rebelB.getItems(), rebelA.getItems(), itemsB);
    }
    public void compatibleItensToTrade(List<Item> itemsA, List<Item> itemsB) throws TradeException {
        AtomicInteger itemsAvalue = new AtomicInteger();
        itemsA.forEach(item -> itemsAvalue.addAndGet(item.itemTotalValue()));
        AtomicInteger itemsBvalue = new AtomicInteger();
        itemsB.forEach(item -> itemsBvalue.addAndGet(item.itemTotalValue()));
        boolean compatible = itemsAvalue.intValue() == itemsBvalue.intValue();
        if (!compatible) throw new TradeException("Insuficient value to trade");
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
    public Item findItem(List<Item> rebelItems, Item item) {
        for (Item rebelItem : rebelItems) {
            if (
                    rebelItem != null && rebelItem.getItem() != null &&
                    rebelItem.getItem().getItem().equals(item.getItem().getItem()) &&
                    rebelItem.getQuantity() > 0
            ) {
                return rebelItem;
            }
        }
        return null;
    }
    public void existItems(List<Item>rebelItems, List<Item>items) throws TradeException {
        for (Item item : items) {
            Item itemRebel = findItem(rebelItems, item);
            if(itemRebel == null || itemRebel.getItem() == null || itemRebel.getQuantity() == 0 ||
                    (itemRebel.getItem().getItem().equals(item.getItem().getItem()) && itemRebel.getQuantity() < item.getQuantity())) throw new TradeException("Insuficient value to trade");
        }
    }
}
