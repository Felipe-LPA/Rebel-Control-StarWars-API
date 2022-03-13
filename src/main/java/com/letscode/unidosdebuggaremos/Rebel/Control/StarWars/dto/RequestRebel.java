package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RequestRebel {
    private String name;
    private int age;
    private String gender;
    private double latitude;
    private double longitude;
//    private String planet;
    private List<RequestItem> items;
}
