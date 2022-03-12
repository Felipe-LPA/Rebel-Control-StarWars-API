package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Gender;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Localization;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ResponseRebel {
    private String name;
    private int age;
    private Gender gender;
    private Localization localization;

    public ResponseRebel(Rebel rebel){
        this.name = rebel.getName();
        this.age = rebel.getAge();
        this.gender = rebel.getGender();
        this.localization = rebel.getLocalization();
    }
    public static List<ResponseRebel> toResponse(List<Rebel> rebels){
        return  rebels.stream().map(ResponseRebel::new).collect(Collectors.toList());
    }
}
