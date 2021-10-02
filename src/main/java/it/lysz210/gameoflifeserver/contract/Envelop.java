package it.lysz210.gameoflifeserver.contract;

/**
 * Basic I/O interface for http response.
 * It carries the data of type T
 * @param <T> type of data
 */
public interface Envelop<T> {
    T getData ();
}
