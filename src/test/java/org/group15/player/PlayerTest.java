package org.group15.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getId_ReturnsId() {
        // Arrange
        var player = new Player(1, "Bob");

        // Act
        int expected = 1;
        int actual = player.getId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getName_ReturnsName() {
        // Arrange
        var player = new Player(1, "Bob");

        // Act
        String expected = "Bob";
        String actual = player.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAccount_ReturnsAccountWithAppropriateAmount() {
        // Arrange
        var player = new Player(1, "Bob");

        // Act
        int expected = 1000;
        int actual = player.getAccount().getAmount();

        // Assert
        assertEquals(expected, actual);
    }
}