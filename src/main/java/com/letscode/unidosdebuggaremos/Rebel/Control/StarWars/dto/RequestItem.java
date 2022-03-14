package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter @Setter
@AllArgsConstructor
public class RequestItem {
    private String itemName;
    @Positive
    private int itemQuantity;
}
