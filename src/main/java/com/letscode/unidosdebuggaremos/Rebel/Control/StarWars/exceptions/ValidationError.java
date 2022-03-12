package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationError {
    private String campo;
    private String messagem;
}
