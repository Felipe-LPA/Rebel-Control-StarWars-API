package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class GeneralReport {
    private String rebelPercentage;
    private String traitorPercentage;
    private AvgItemsQuantity avgItemQuantity;
    private int lostPoints;
}
