package it.lysz210.gameoflifeserver.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;

@Schema(
        description = "Request for Game of Life"
)
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
