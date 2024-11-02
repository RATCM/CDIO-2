package org.group15.game.context;

import org.group15.player.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameContextTest {

    @Test
    void setState_ChangesContextState() {
        // Arrange
        var sut = new GameContext(new Player[]{
           new Player(0, "Alice"),
           new Player(1, "Bob"),
           new Player(2, "Carl")
        });

        // Act
        sut.setState(new ExtraTurnState());

        var expected = ExtraTurnState.class;
        var actual = sut.getState().getClass();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setDefaultState_SetsStateToDefault() {
        // Arrange
        var sut = new GameContext(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        });

        // Act
        sut.setState(new ExtraTurnState());
        sut.setDefaultState();

        var expected = DefaultState.class;
        var actual = sut.getState().getClass();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("gameStatesProvider")
    void getState_ReturnsTheCurrentState(GameState state) {
        // Arrange
        var sut = new GameContext(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        });

        // Act
        sut.setState(state);

        var expected = state.getClass();
        var actual = sut.getState().getClass();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void doNextPlayerTurn_ChangesCurrentPlayer() {
        // Arrange
        var sut = new GameContext(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        });

        // Act
        Player initial = sut.getCurrentPlayer();

        sut.doNextPlayerTurn();

        Player expected = sut.getAllPlayers()[1];
        Player actual = sut.getCurrentPlayer();

        // Assert
        assertEquals(expected, actual);
        assertNotEquals(initial, actual);
    }

    @Test
    void getAllPlayers_ReturnsAllPlayers() {
        // Arrange
        Player[] players = new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        };

        var sut = new GameContext(players);

        // Act
        Player[] actual = sut.getAllPlayers();

        // Assert
        assertArrayEquals(players, actual);
    }

    @Test
    void getCurrentPlayer_ReturnsCurrentPlayer() {
        // Arrange
        var sut = new GameContext(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        });

        // Act
        Player expected = sut.getAllPlayers()[0];
        Player actual = sut.getCurrentPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setCurrentPlayer_ChangesTheCurrentPlayer() {
        // Arrange
        Player[] players = new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob"),
                new Player(2, "Carl")
        };
        var sut = new GameContext(players);

        // Act
        sut.setCurrentPlayer(players[2]);

        Player expected = players[2];
        Player actual = sut.getCurrentPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> gameStatesProvider(){
        return Stream.of(
                Arguments.of(new DefaultState()),
                Arguments.of(new ExtraTurnState())
        );
    }
}