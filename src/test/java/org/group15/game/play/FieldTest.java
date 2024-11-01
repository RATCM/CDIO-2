package org.group15.game.play;

import org.group15.game.effects.Effect;
import org.group15.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mock;


class FieldTest {

    @Test
    void addPlayer_Fails_IfPlayerIdExists() {
        // Arrange
        Effect effect = mock(Effect.class);
        Field sut = new Field(new Effect[]{effect}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(0,"Bob");

        // Act
        sut.addPlayer(p1);
        var success = sut.addPlayer(p2);

        // Assert
        assertAll(
                () -> assertFalse(success),
                () -> assertFalse(sut.hasPlayer(p2))
        );
    }

    @Test
    void addPlayer_Succeeds_IfPlayerIdDoesntExist() {
        // Arrange
        Effect effect = mock(Effect.class);
        Field sut = new Field(new Effect[]{effect}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");

        // Act
        var success1 = sut.addPlayer(p1);
        var success2 = sut.addPlayer(p2);

        // Assert
        assertAll(
                () -> assertTrue(success1),
                () -> assertTrue(success2),
                () -> assertTrue(sut.hasPlayer(p1)),
                () -> assertTrue(sut.hasPlayer(p2))
        );
    }

    @Test
    void removePlayer_Fails_IfPlayerIdDoesntExist() {
        // Arrange
        Effect effect = mock(Effect.class);
        Field sut = new Field(new Effect[]{effect}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");
        sut.addPlayer(p1);

        // Act
        var success = sut.removePlayer(p2);

        // Assert
        assertAll(
                () -> assertFalse(success),
                () -> assertTrue(sut.hasPlayer(p1)),
                () -> assertFalse(sut.hasPlayer(p2))
        );
    }

    @Test
    void removePlayer_Succeeds_IfPlayerIdExists() {
        // Arrange
        Effect effect = mock(Effect.class);
        Field sut = new Field(new Effect[]{effect}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");

        sut.addPlayer(p1);
        sut.addPlayer(p2);

        // Act
        var success1 = sut.removePlayer(p1);
        var success2 = sut.removePlayer(p2);

        // Assert
        assertAll(
                () -> assertTrue(success1),
                () -> assertTrue(success2),
                () -> assertFalse(sut.hasPlayer(p1)),
                () -> assertFalse(sut.hasPlayer(p2))
        );
    }

    @Test
    void hasPlayer_ReturnsFalse_IfPlayerIdDoesntExist() {
        // Arrange
        Effect effect = mock(Effect.class);
        Field sut = new Field(new Effect[]{effect}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");

        sut.addPlayer(p1);

        // Act
        var success = sut.hasPlayer(p2);

        // Assert
        assertFalse(success);
    }

    @Test
    void hasPlayer_ReturnsTrue_IfPlayerIdExists() {
        // Arrange
        Effect effect = mock(Effect.class);
        Field sut = new Field(new Effect[]{effect}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");
        sut.addPlayer(p1);
        sut.addPlayer(p2);

        // Act
        var success1 = sut.hasPlayer(p1);
        var success2 = sut.hasPlayer(p2);

        // Assert
        assertAll(
                () -> assertTrue(success1),
                () -> assertTrue(success2)
        );
    }

    @Test
    void applyFieldEffects_ReturnsFalse_IfAnyEffectFails() {
        // Arrange
        Effect effect1 = mock(Effect.class);
        Effect effect2 = mock(Effect.class);

        when(effect1.apply()).thenReturn(true);
        when(effect2.apply()).thenReturn(false);

        Field sut = new Field(new Effect[]{effect1, effect2}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");
        sut.addPlayer(p1);
        sut.addPlayer(p2);

        // Act
        var success = sut.applyFieldEffects();

        // Assert
        assertFalse(success);
    }

    @Test
    void applyFieldEffects_ReturnsTrue_IfAllEffectsSucceeds() {
        // Arrange
        Effect effect1 = mock(Effect.class);
        Effect effect2 = mock(Effect.class);

        when(effect1.apply()).thenReturn(true);
        when(effect2.apply()).thenReturn(true);

        Field sut = new Field(new Effect[]{effect1, effect2}, 1);

        Player p1 = new Player(0,"Alice");
        Player p2 = new Player(1,"Bob");
        sut.addPlayer(p1);
        sut.addPlayer(p2);

        // Act
        var success = sut.applyFieldEffects();

        // Assert
        assertTrue(success);
    }

    @Test
    void getDescription_ReturnsAppropriateDescription() {
        // Arrange
        Effect effect1 = mock(Effect.class);
        Effect effect2 = mock(Effect.class);

        when(effect1.getDescription()).thenReturn("d1");
        when(effect2.getDescription()).thenReturn("d2");

        Field sut = new Field(new Effect[]{effect1, effect2}, 1);
        sut.description = "field:";

        // Act
        var expected =
                "field:" +
                System.lineSeparator() +
                "d1" +
                System.lineSeparator() +
                "d2";

        var actual = sut.getDescription();

        // Assert
        assertEquals(expected, actual);
    }
}