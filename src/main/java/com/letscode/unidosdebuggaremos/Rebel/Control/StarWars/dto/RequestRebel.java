package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Localization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RequestRebel {
    @NotNull(message = "Não pode ser nulo") @NotEmpty(message = "Não pode ser Vazio")
    private String name;
    @Positive
    @NotNull(message = "Não pode ser nulo")
    private int age;
    @NotNull(message = "Não pode ser nulo") @NotEmpty(message = "Não pode ser Vazio")
    private String gender;
    @NotNull(message = "Não pode ser nulo")
    private double latitude;
    @NotNull(message = "Não pode ser nulo")
    private double longitude;
    private List<RequestItem> items;
}
