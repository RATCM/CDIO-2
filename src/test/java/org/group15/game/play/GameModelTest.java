package org.group15.game.play;

import org.group15.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {

    @Test
    void getContext_ReturnsGameContext() {
        // Arrange
        var sut = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
        });

        // Act
        var context = sut.getContext();

        // Assert
        assertNotNull(context);
    }

    @Test
    void getFields_ReturnsFields() {
        // Arrange
        var sut = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
        });

        // Act
        var fields = sut.getFields();

        // Assert
        assertNotNull(fields);
    }
}