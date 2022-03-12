package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Gender;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Localization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestRebel {
    private String name;
    private int age;
    private String gender;
    private double latitude;
    private double longitude;
    private String planet;
}
