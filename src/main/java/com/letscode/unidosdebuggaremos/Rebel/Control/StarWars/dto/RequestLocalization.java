package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class RequestLocalization {
    @NotNull(message = "Não pode ser nulo")
    private double latitude;
    @NotNull(message = "Não pode ser nulo")
    private double longitude;
}
