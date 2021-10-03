package it.lysz210.gameoflifeserver.controller;

import it.lysz210.gameoflifeserver.contract.GameOfLifeRequest;
import it.lysz210.gameoflifeserver.contract.GameOfLifeResponse;
import it.lysz210.gameoflifeserver.service.GameOfLiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MainController {

    private final GameOfLiveService gameOfLive;

    @PostMapping("/compute")
    public GameOfLifeResponse compute (@Valid @RequestBody GameOfLifeRequest request) {
        return gameOfLive.call(request.getData())
                .map(cell -> GameOfLifeResponse.builder().data(cell).build())
                .orElse(null);
    }
}
