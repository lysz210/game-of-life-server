package it.lysz210.gameoflifeserver.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class TwoFreezeThreeActiveTest {

    @SpyBean
    TwoFreezeThreeActive gameLogic;

    @ParameterizedTest
    @CsvSource({
        "000000000,0",
        "000010000,0",
        "100000000,1",
        "100010000,1",
        "111101111,8",
        "111111111,8",
    })
    void shouldCountNeighbors (String input, int expected) {
        assertThat(this.gameLogic.countNeighbors(input))
                .as("Count neighbors for %s expected %s", input, expected)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0,3",
        "1,3",
        "1,2",
    })
    void shouldReturnTrue (char currentState, long neighbors) {
        assertThat(this.gameLogic.isActive(currentState, neighbors))
            .as("isActive must be true for state %s with %d neighbors", currentState, neighbors)
            .isTrue();
    }

    @ParameterizedTest
    @CsvSource({
        ",0",
        ",1",
        "0,2",
        ",4",
        ",5",
        ",6",
        ",7",
        ",8",
    })
    void shoudReturnFalse (Character currentState, long neighbors) {
        boolean checkOne = currentState == null || currentState.equals('1');
        boolean checkZero = currentState == null || currentState.equals('0');
        assertSoftly(bundle -> {
           if (checkOne) {
               bundle.assertThat(this.gameLogic.isActive('1', neighbors))
                        .as("isActive must be false for state 1 with %d neighbors", neighbors)
                        .isFalse();
           }
           if (checkZero) {
               bundle.assertThat(this.gameLogic.isActive('0', neighbors))
                       .as("isActive must be false for state 0 with %d neighbors", neighbors)
                       .isFalse();
           }
        });
    }

    @Test
    void shoudCache () {
        String input = "000000000";
        assertThat(this.gameLogic.apply(input))
                .isEqualTo(this.gameLogic.apply(input));
        verify(this.gameLogic).apply(anyString());
    }

}