package org.group15.dice;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DiceModelTest {

    @Test
    void getDice_ReturnsAllDice() {
        // Arrange
        var dice = IntStream.range(0,10)
                .mapToObj(x -> new Die(6))
                .toArray(Die[]::new);

        var sut = new DiceModel(dice);

        // Act
        Die[] actual = sut.getDice();

        // Assert
        assertArrayEquals(dice, actual);
    }
}