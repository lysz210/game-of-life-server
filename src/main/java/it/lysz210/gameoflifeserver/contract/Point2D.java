package it.lysz210.gameoflifeserver.contract;

import java.math.BigInteger;

/**
 * reppresetation of a basic 2d point.
 * For this implementation the x and y coordinate
 * are readonly.
 */
public interface Point2D {

    BigInteger getX ();

    BigInteger getY ();
}
