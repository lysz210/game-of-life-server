package it.lysz210.gameoflifeserver.contract;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;

@Data
@Builder
public class GameOfLifeRequest implements Request<MatrixElement> {

    @Valid
    @NotNull(message = "Data are required.")
    private final MatrixElement data;

    @ConstructorProperties("data")
    public GameOfLifeRequest(MatrixElement data) {
        this.data = data;
    }
}
