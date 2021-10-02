package it.lysz210.gameoflifeserver.contract;

/**
 * representation of an element with some data
 * and coordinates
 *
 * @param <T> type of date stored in this element
 */
public interface Element <T> {
    /**
     * retrieve the data of this element
     * @return the date
     */
    T getData ();

    /**
     * retrieve the 2d coordinates of this element
     * @return the 2d coordinates
     */
    Point2D getCoordinate ();
}
