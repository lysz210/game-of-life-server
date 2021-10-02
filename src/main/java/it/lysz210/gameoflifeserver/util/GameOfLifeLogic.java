package it.lysz210.gameoflifeserver.util;

import java.util.function.Function;

/**
 * basic interface of
 * Game of Life Logic
 * @param <I> of input
 */
public interface GameOfLifeLogic<I> extends Function<I, Character> {
}
