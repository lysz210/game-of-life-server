package it.lysz210.gameoflifeserver.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameOfLiveResponse implements Response<String> {

    private String data;
}
