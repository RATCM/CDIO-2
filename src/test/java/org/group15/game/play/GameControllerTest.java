package org.group15.game.play;

import org.group15.dice.DiceController;
import org.group15.dice.DiceModel;
import org.group15.dice.Die;
import org.group15.game.context.GameContext;
import org.junit.jupiter.api.Test;
import org.group15.player.Player;
import org.group15.dice.DiceView;
import org.mockito.ArgumentMatchers;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class GameControllerTest {

    @Test
    void rollDice_CallsShowPlayerInfo(){
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        DiceController diceController = mock(DiceController.class);
        GameController sut = new GameController(model, view, diceController);

        Die[] dice = new Die[]{
                mock(Die.class),
                mock(Die.class),
        };

        when(dice[0].getValue()).thenReturn(3);
        when(dice[1].getValue()).thenReturn(2);

        when(diceController.retrieveUserRoll()).thenReturn(new DiceModel(dice));

        // Act
        sut.rollDice();

        // Assert
        verify(view, times(1)).showPlayerInfo(any(Player.class));
    }

    @Test
    void rollDice_CallsShowField(){
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        DiceController diceController = mock(DiceController.class);
        GameController sut = new GameController(model, view, diceController);

        Die[] dice = new Die[]{
                mock(Die.class),
                mock(Die.class),
        };

        when(dice[0].getValue()).thenReturn(3);
        when(dice[1].getValue()).thenReturn(2);

        when(diceController.retrieveUserRoll()).thenReturn(new DiceModel(dice));

        // Act
        sut.rollDice();

        // Assert
        verify(view, times(1)).showField(any(Field.class));
    }

    @Test
    void rollDice_AppliesFieldEffects(){
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        DiceController diceController = mock(DiceController.class);
        GameController sut = new GameController(model, view, diceController);

        Die[] dice = new Die[]{
                mock(Die.class),
                mock(Die.class),
        };

        when(dice[0].getValue()).thenReturn(3);
        when(dice[1].getValue()).thenReturn(2);

        when(diceController.retrieveUserRoll()).thenReturn(new DiceModel(dice));

        // Act
        sut.rollDice();

        // We land on field 5, which removes 20 points from player
        int expected = 1000 - 20;
        int actual = model.getContext().getAllPlayers()[0].getAccount().getAmount();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void rollDice_ChangesPlayerTurn(){
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        DiceController diceController = mock(DiceController.class);
        GameController sut = new GameController(model, view, diceController);

        Die[] dice = new Die[]{
                mock(Die.class),
                mock(Die.class),
        };

        when(dice[0].getValue()).thenReturn(3);
        when(dice[1].getValue()).thenReturn(2);

        when(diceController.retrieveUserRoll()).thenReturn(new DiceModel(dice));

        // Act
        sut.rollDice();

        Player expected = model.getContext().getAllPlayers()[1];
        Player actual = model.getContext().getCurrentPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void rollDice_RemovesPlayerFromField(){
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        DiceController diceController = mock(DiceController.class);
        GameController sut = new GameController(model, view, diceController);

        Die[] dice = new Die[]{
                mock(Die.class),
                mock(Die.class),
        };

        when(dice[0].getValue()).thenReturn(3);
        when(dice[1].getValue()).thenReturn(2);

        when(diceController.retrieveUserRoll()).thenReturn(new DiceModel(dice));

        // Act
        sut.rollDice();
        boolean playerOnField = model.getFields().get(2).hasPlayer(model.getContext().getAllPlayers()[0]);

        // Assert
        assertFalse(playerOnField);
    }

    @Test
    void rollDice_AddsPlayerToField(){
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        DiceController diceController = mock(DiceController.class);
        GameController sut = new GameController(model, view, diceController);

        Die[] dice = new Die[]{
                mock(Die.class),
                mock(Die.class),
        };

        when(dice[0].getValue()).thenReturn(3);
        when(dice[1].getValue()).thenReturn(2);

        when(diceController.retrieveUserRoll()).thenReturn(new DiceModel(dice));

        // Act
        sut.rollDice();
        boolean playerOnField = model.getFields().get(5).hasPlayer(model.getContext().getAllPlayers()[0]);

        // Assert
        assertTrue(playerOnField);
    }



    @Test
    void checkForWinner_ReturnsTrue_IfAnyPlayerHasWon() {
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameController sut = new GameController(model, mock(GameView.class), mock(DiceController.class));

        model.getContext().getAllPlayers()[0].getAccount().addAmount(2000);

        // Act
        boolean value = sut.checkForWinner();

        // Assert
        assertTrue(value);
    }

    @Test
    void checkForWinner_ReturnsFalse_IfNoPlayerHasWon() {
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameController sut = new GameController(model, mock(GameView.class), mock(DiceController.class));

        // Act
        boolean value = sut.checkForWinner();

        // Assert
        assertFalse(value);
    }


    @Test
    void displayWinningPlayer_ShowsWinningPlayer_IfAnyPlayerHasWon() {
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        GameController sut = new GameController(model, view, mock(DiceController.class));

        model.getContext().getAllPlayers()[0].getAccount().addAmount(2000);

        // Act
        boolean value = sut.displayWinningPlayer();

        // Assert
        assertTrue(value);
        verify(view, times(1)).showWinningPlayer(any(Player.class));
    }

    @Test
    void displayWinningPlayer_DoesNotShowWinningPlayer_IfNoPlayerHasWon() {
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameView view = mock(GameView.class);
        GameController sut = new GameController(model, view, mock(DiceController.class));

        // Act
        boolean value = sut.displayWinningPlayer();

        // Assert
        assertFalse(value);
        verify(view, never()).showWinningPlayer(any(Player.class));
    }

    @Test
    void getContext_ReturnsGameContext() {
        // Arrange
        GameModel model = new GameModel(new Player[]{
                new Player(0, "Alice"),
                new Player(1, "Bob")
        });
        GameController sut = new GameController(model, mock(GameView.class), mock(DiceController.class));

        // Act
        GameContext context = sut.getContext();

        // Assert
        assertNotNull(context);
    }
}