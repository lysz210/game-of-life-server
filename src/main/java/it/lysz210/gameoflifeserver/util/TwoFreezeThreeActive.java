package it.lysz210.gameoflifeserver.util;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * function to compute if the cell on center of
 * a 3x3 matrix will be 1 or 0 based on his neighbors
 *
 * The matrix is representid as string.
 * [
 *  [a, b, c],
 *  [d, e, f],
 *  [g, h, i]
 * ]
 * the corresponding string is "abcdefghi"
 * where e is the cell to process.
 */
@Service("2freeze3active")
public class TwoFreezeThreeActive implements GameOfLifeLogic<String> {
    /**
     * the index of the current cell,
     * also the center of the matrix
     */
    public static final int CELL_INDEX = 4;
    /**
     * char rappresentation of active state
     * of a cell
     */
    public static final char ACTIVE = '1';

    @Override
    public Character apply(@NonNull String linearMatrix) {
        return isActive(linearMatrix.charAt(CELL_INDEX), countNeighbors(linearMatrix)) ? '1' : '0';
    }

    /**
     * count active neighbors of the cell.
     * @param linearMatrix 3x3 matrix as string
     * @return number of active neighbors
     */
    long countNeighbors(@NonNull String linearMatrix) {
        return IntStream.range(0, 9)
                .filter(i -> i != CELL_INDEX)
                .map(linearMatrix::charAt)
                .filter(ch -> ACTIVE == ch)
                .count();
    }

    /**
     * check if the cell is active or not.
     * if cell is NOT active and has 3 neighbors
     *  it activate (1)
     * if chell is active and has 2 or 3 neighbors
     *  it stay active (1)
     * else false
     * @param cell current state of the cell
     * @param neighbors number
     * @return the next state of the cell
     */
    boolean isActive(char cell, long neighbors) {
        return (neighbors == 3) || cell == '1' && neighbors == 2;
    }
}
