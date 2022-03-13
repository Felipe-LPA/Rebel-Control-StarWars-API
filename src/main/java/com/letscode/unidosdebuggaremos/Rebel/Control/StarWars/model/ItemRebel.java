package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class ItemRebel {
    private String item;
    private int value;

    public ItemRebel(String item){
        this.item = item.toLowerCase(Locale.ROOT);
        this.value = this.whichValueItem();
    }

    public int whichValueItem(){
        if(Objects.equals(this.item, "weapon")){
            return 4;
        }else if(Objects.equals(this.item, "ammunation")){
            return 3;
        }else if(Objects.equals(this.item, "water")){
            return 2;
        }else if(Objects.equals(this.item, "food")){
            return 1;
        }
        return 0;
    }
}
