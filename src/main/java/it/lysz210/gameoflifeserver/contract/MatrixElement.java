package it.lysz210.gameoflifeserver.contract;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.beans.ConstructorProperties;

@Data
@Builder
public class MatrixElement implements Element<String> {

    @NotNull(message = "Matrix data required.")
    @Pattern(regexp = "[01]{9}", message = "data deve contenere esattamente 9 cifre di zeri e/o uni.")
    private final String data;

    @Valid
    @NotNull (message = "Coordinate must be present.")
    @JsonDeserialize(as = ImmutablePoint2D.class)
    private final Point2D coordinate;

    @ConstructorProperties({"data", "coordinate"})
    public MatrixElement (String data, Point2D coordinate) {
        this.data = data;
        this.coordinate = coordinate;
    }

}
