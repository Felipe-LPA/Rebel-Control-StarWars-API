package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.utils.notduplicateditems.NotDuplicatedItems;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.utils.nottraitor.NotTraitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class RequestTrade {
    @NotTraitor
    private UUID rebelIdA;
    private List<RequestItem> rebelItensA;
    @NotTraitor
    private UUID rebelIdB;
    @NotDuplicatedItems
    private List<RequestItem> rebelItensB;
}
