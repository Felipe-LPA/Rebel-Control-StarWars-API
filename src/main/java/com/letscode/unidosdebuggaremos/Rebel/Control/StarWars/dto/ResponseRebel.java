package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Gender;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.ItemRebel;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Localization;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ResponseRebel {
    private UUID id;
    private String name;
    private int age;
    private Gender gender;
    private Localization localization;
    private List<ItemRebel> items;

    public ResponseRebel(Rebel rebel){
        this.id = rebel.getId();
        this.name = rebel.getName();
        this.age = rebel.getAge();
        this.gender = rebel.getGender();
        this.localization = rebel.getLocalization();
        this.items = rebel.getItems();
    }
    public static List<ResponseRebel> toResponse(List<Rebel> rebels){
        return  rebels.stream().map(ResponseRebel::new).collect(Collectors.toList());
    }
}
