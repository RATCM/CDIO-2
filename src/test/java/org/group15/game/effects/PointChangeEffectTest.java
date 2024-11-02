package org.group15.game.effects;

import org.group15.game.context.GameContext;
import org.group15.player.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PointChangeEffectTest {

    @ParameterizedTest
    @ValueSource(ints = {-20, -10, -1, 0, 1, 10, 20})
    void apply_ChangesAccountAppropriately(int value) {
        // Arrange
        GameContext context = mock(GameContext.class);
        Player player = new Player(1, "Bob");

        when(context.getCurrentPlayer()).thenReturn(player);

        var sut = new PointChangeEffect(value, context);

        // Act
        sut.apply();
        int expected = Math.clamp(1000 + value, 0, 3000);
        int actual = player.getAccount().getAmount();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void getDescription_ReturnsAppropriateDescription_WhenPointsIsPositive(int value) {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new PointChangeEffect(value, context);

        // Act
        String expected = String.format("Adds %d points to player", value);
        String actual = sut.getDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getDescription_ReturnsAppropriateDescription_WhenPointsIsZero() {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new PointChangeEffect(0, context);

        // Act
        String expected = "No points added or removed";
        String actual = sut.getDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -20})
    void getDescription_ReturnsAppropriateDescription_WhenPointsIsNegative(int value) {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new PointChangeEffect(value, context);

        // Act
        String expected = String.format("Removes %d points from player", -value);
        String actual = sut.getDescription();

        // Assert
        assertEquals(expected, actual);
    }



    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void getAlignment_ReturnsGood_WhenPointsIsPositive(int value) {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new PointChangeEffect(value, context);

        // Act
        var expected = Alignment.Good;
        var actual = sut.getAlignment();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAlignment_ReturnsNeutral_WhenPointsIsZero() {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new PointChangeEffect(0, context);

        // Act
        var expected = Alignment.Neutral;
        var actual = sut.getAlignment();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -20})
    void getAlignment_ReturnsBad_WhenPointsIsNegative(int value) {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new PointChangeEffect(value, context);

        // Act
        var expected = Alignment.Bad;
        var actual = sut.getAlignment();

        // Assert
        assertEquals(expected, actual);
    }
}