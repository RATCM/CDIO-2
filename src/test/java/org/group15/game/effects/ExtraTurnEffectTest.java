package org.group15.game.effects;

import org.group15.game.context.GameContext;
import org.group15.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ExtraTurnEffectTest {

    @Test
    void apply_GivesPlayerExtraTurn() {
        // Arrange
        GameContext context = new GameContext(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl"),
        });

        var sut = new ExtraTurnEffect(context);

        // Act
        sut.apply();
        context.doNextPlayerTurn();

        Player expected = context.getAllPlayers()[0];
        Player actual = context.getCurrentPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getDescription_ReturnsAppropriateDescription() {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new ExtraTurnEffect(context);

        // Act
        String expected = "Player gets another turn!";
        String actual = sut.getDescription();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAlignment_ReturnsGood() {
        // Arrange
        GameContext context = mock(GameContext.class);
        var sut = new ExtraTurnEffect(context);

        // Act
        Alignment expected = Alignment.Good;
        Alignment actual = sut.getAlignment();

        // Assert
        assertEquals(expected, actual);
    }
}