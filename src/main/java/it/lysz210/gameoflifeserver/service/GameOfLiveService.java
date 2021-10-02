package it.lysz210.gameoflifeserver.service;

import it.lysz210.gameoflifeserver.contract.CellElement;
import it.lysz210.gameoflifeserver.contract.MatrixElement;
import it.lysz210.gameoflifeserver.util.GameOfLifeLogic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * execute the game logic on input data
 */
@org.springframework.stereotype.Service
public class GameOfLiveService implements Service<MatrixElement, Optional<CellElement>> {

    /**
     * game logic to apply
     */
    private final GameOfLifeLogic<String> gameLogic;

    /**
     * current logic 2freeze3active
     * @param gameLogic to apply
     */
    public GameOfLiveService (@Qualifier("2freeze3active") GameOfLifeLogic<String> gameLogic) {
        this.gameLogic = gameLogic;
    }

    /**
     * extract data from input,
     * apply the game logic
     * then build che cellElement
     * @param input for the service
     * @return cellElement
     */
    @Override
    public Optional<CellElement> call(@NonNull MatrixElement input) {
        return Optional.of(input)
                .map(MatrixElement::getData)
                .map(gameLogic)
                .map(data -> CellElement.builder().data(data).coordinate(input.getCoordinate()).build());
    }
}
