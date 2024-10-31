package org.group15.dice;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;

class DieTest {
    @DisplayName("Ensures that the rolls are random")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 60, 100, 1000})
    void roll_ShouldBeRandom(int sides) {
        // Arrange
        Die die = new Die(sides, new Random(sides)); // We set a seed to the test is consistent
        int iterations = 1_000_000; // A million iterations is enough
        double expectedMean = (sides+1)/2.0;

        // Act
        int sum = 0;
        for(int i = 0; i < iterations; i++) {
            die.roll();
            int val = die.getValue();
            sum += die.getValue();
        }
        double actualMean = (double)sum/iterations;

        // Assert
        // The actual mean value is less than 1% different from the expected value
        assertTrue(Math.abs(1-actualMean/expectedMean) < 0.01);
    }

    @DisplayName("Ensures the value is always initialized as -1")
    @Test
    void getValue_ShouldReturnNegativeOne_WhenInitialized() {
        // Arrange
        Die die = new Die(6);

        // Act
        int value = die.getValue();

        // Assert
        assertEquals(-1,value);
    }

    @DisplayName("Ensures the value is always valid after a dice roll")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9})
    void getValue_ShouldReturnAValidValue_AfterDiceRoll(int sides) {
        // Arrange
        Die die = new Die(sides, new Random(sides));

        // Act
        die.roll();
        int value = die.getValue();

        // Assert
        assertTrue(value >= 1 && value <= sides);
    }
}
