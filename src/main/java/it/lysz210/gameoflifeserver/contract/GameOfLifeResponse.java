package it.lysz210.gameoflifeserver.contract;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class GameOfLifeResponse implements Response<CellElement> {

    @NotNull(message = "Data are required.")
    private final CellElement data;
}
