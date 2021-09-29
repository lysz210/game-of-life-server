package it.lysz210.gameoflifeserver.contract;

import lombok.Data;

/**
 * basic Output interface for http calls
 * @param <T>
 */
public interface Response<T> extends Envelop<T> {

    @Data
    class EmptyResponse implements Response<Void> {
        Void data;
    }
}
