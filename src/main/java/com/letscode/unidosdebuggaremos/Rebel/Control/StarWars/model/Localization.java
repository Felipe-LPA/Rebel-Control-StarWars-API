package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Localization {
    private double latitude;
    private double longitude;
    private Planet planet;
}
