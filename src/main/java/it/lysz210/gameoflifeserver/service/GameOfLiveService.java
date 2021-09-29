package it.lysz210.gameoflifeserver.service;

import org.springframework.lang.NonNull;

import java.util.Optional;

@org.springframework.stereotype.Service
public class GameOfLiveService implements Service<String, Optional<String>> {
    @Override
    public Optional<String> call(@NonNull String input) {
        return Optional.of(input.substring(4, 5));
    }
}
