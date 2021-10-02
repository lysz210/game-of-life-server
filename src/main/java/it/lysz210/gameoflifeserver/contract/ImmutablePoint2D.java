package it.lysz210.gameoflifeserver.contract;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.math.BigInteger;

@Data
@Builder
public class ImmutablePoint2D implements Point2D {

    @NonNull
    @NotNull(message = "x is required.")
    private final BigInteger x;

    @NonNull
    @NotNull(message = "y is required.")
    private final BigInteger y;

    @ConstructorProperties({"x", "y"})
    public ImmutablePoint2D (BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }

}
