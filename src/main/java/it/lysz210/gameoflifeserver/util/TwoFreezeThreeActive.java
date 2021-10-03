package it.lysz210.gameoflifeserver.util;

import org.springframework.beans.factory.annotation.Value;
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
    private final int cellIndex;
    /**
     * char rappresentation of active state
     * of a cell
     */
    private final char actrive;

    public TwoFreezeThreeActive (
        @Value("${gol.cell-index}") int cellIndex,
        @Value("${gol.active-state}") char activeState
    ) {
        this.actrive = activeState;
        this.cellIndex = cellIndex;
    }

    @Override
    public Character apply(@NonNull String linearMatrix) {
        return isActive(linearMatrix.charAt(this.cellIndex), countNeighbors(linearMatrix)) ? '1' : '0';
    }

    /**
     * count active neighbors of the cell.
     * @param linearMatrix 3x3 matrix as string
     * @return number of active neighbors
     */
    long countNeighbors(@NonNull String linearMatrix) {
        return IntStream.range(0, 9)
                .filter(i -> i != this.cellIndex)
                .map(linearMatrix::charAt)
                .filter(ch -> this.actrive == ch)
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
        return (neighbors == 3) || cell == this.actrive && neighbors == 2;
    }
}
