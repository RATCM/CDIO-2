package org.group15.game.context;

import org.group15.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExtraTurnStateTest {

    @Test
    void doNextTurn_DoesntChangeCurrentPlayer() {
        // Arrange
        var sut = new ExtraTurnState();
        GameContext context = new GameContext(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        });

        // Act
        sut.doNextTurn(context);

        Player expected = context.getAllPlayers()[0];
        Player actual = context.getCurrentPlayer();

        // Assert
        assertEquals(expected, actual);
    }
}