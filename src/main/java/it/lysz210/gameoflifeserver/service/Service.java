package it.lysz210.gameoflifeserver.service;

import org.springframework.lang.NonNull;

/**
 * Basic rappresetantion of a service
 * @param <I> type of the service
 * @param <O></O> type of the service
 */
@FunctionalInterface
public interface Service<I, O> {
    /**
     * call the service with an input
     * to get an output
     * @param input for the service
     * @return output for the service
     */
    O call (@NonNull I input);
}
