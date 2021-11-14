package it.lysz210.gameoflifeserver.contract;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * reppresetation of a basic 2d point.
 * For this implementation the x and y coordinate
 * are readonly.
 */
@Schema(description = "Representation of a point in a 2D plain")
public interface Point2D {

    @Schema(
            description = "X coordinate of the point",
            example = "0"
    )
    @NotNull
    BigInteger getX ();

    @Schema(
            description = "X coordinate of the point",
            example = "0"
    )
    @NotNull
    BigInteger getY ();
}
