package it.lysz210.gameoflifeserver.controller;

import it.lysz210.gameoflifeserver.contract.GameOfLiveResponse;
import it.lysz210.gameoflifeserver.contract.Response;
import it.lysz210.gameoflifeserver.service.GameOfLiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Pattern;

@Controller
@RequestMapping("/v1")
@Validated
@ResponseBody
@RequiredArgsConstructor
public class MainController {

    private final GameOfLiveService gameOfLive;

    @GetMapping("/compute")
    public Response<String> compute (
            @RequestParam
            @Pattern(regexp = "[01]{9}", message = "data deve contenere esattamente 9 cifre di Zeri e/o uni.")
            String data
    ) {
        return gameOfLive.call(data)
                .map(cell -> GameOfLiveResponse.builder().data(cell).build())
                .orElse(null);
    }
}
