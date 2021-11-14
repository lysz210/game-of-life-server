package it.lysz210.gameoflifeserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.lysz210.gameoflifeserver.contract.GameOfLifeRequest;
import it.lysz210.gameoflifeserver.contract.GameOfLifeResponse;
import it.lysz210.gameoflifeserver.service.GameOfLiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MainController {

    private final GameOfLiveService gameOfLive;

    @PostMapping("/compute")
    @Operation(summary = "compute game of life logic for single cell with his heighbors")
    @ResponseStatus(HttpStatus.OK)
    public GameOfLifeResponse compute (@Valid @RequestBody GameOfLifeRequest request) {
        return gameOfLive.call(request.getData())
                .map(cell -> GameOfLifeResponse.builder().data(cell).build())
                .orElse(null);
    }
}
