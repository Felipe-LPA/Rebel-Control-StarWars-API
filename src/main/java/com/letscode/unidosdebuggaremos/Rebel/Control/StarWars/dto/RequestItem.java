package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RequestItem {
    private String itemName;
    private int itemQuantity;
}
