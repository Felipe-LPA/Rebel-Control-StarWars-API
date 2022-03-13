package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Rebel {
    private UUID id;
    private String name;
    private int age;
    private Gender gender;
    private Localization localization;
    private List<Item> items;
    private int reportedAsTraitor = 0;

    public boolean reportBetrayal() {
        this.reportedAsTraitor++;
        return true;
    }
    public boolean isTraitor() {
        return this.reportedAsTraitor > 2;
    }
}
