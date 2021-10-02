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
public class CellElement implements Element<Character> {

    @NotNull(message = "Matrix data required.")
    @Pattern(regexp = "[01]", message = "data deve contenere esattamente 1 cifra di zero e/o uno.")
    private final Character data;

    @Valid
    @NotNull (message = "Coordinate must be present.")
    @JsonDeserialize(as = ImmutablePoint2D.class)
    private final Point2D coordinate;

    @ConstructorProperties({"data", "coordinate"})
    public CellElement(Character data, Point2D coordinate) {
        this.data = data;
        this.coordinate = coordinate;
    }

}
