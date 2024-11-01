package org.group15.game.play;

import org.group15.dice.DiceController;
import org.group15.dice.DiceModel;
import org.group15.dice.Die;
import org.group15.game.context.GameContext;
import org.group15.player.Player;

import java.util.Scanner;

public class GameController {
    private GameView view;
    private GameModel model;
    private DiceController diceController;

    public GameController(Player[] player, Scanner scanner){
        this.model = new GameModel(player);
        this.view = new SimpleGameView(scanner);
        this.diceController = new DiceController(2,6, scanner);

    }

    // Used if you wanna use a different GameView instead
    // of the default one
    public GameController(Player[] player, GameView view, Scanner scanner){
        this.model = new GameModel(player);
        this.view = view;
        this.diceController = new DiceController(2,6, scanner);
    }

    // Calls the getUserRoll method in DiceController
    // And updates the game context
    public void rollDice(){
        int roll = calculateFieldPosition(diceController.retrieveUserRoll().getDice());
        Player player = model.getContext().getCurrentPlayer();

        Field previousField = findFieldWithPlayer(player);
        Field nextField = model.getFields().get(roll);

        removePlayerFromField(player, previousField);

        putPlayerOnField(player, nextField);

        applyFieldEffects(nextField);

        showField(nextField);
        displayPlayerInfo(player);

        model.getContext().doNextPlayerTurn();

    }

    // Displays the field description to the player
    // through the GameView interface
    private void showField(Field field){
        view.showField(field);
    }

    // Returns whether some player has won.
    public boolean checkForWinner(){
        for(Player player: model.getContext().getAllPlayers()){
            if (player.getAccount().getAmount() == 3000){
                return true;
            }

        }
        return false;
    }

    private void displayPlayerInfo(Player player){
        view.showPlayerInfo(player);
    }

    // Displays the winning player through the
    // GameView interface
    public boolean displayWinningPlayer(){
        Player winner;

        for(Player player: model.getContext().getAllPlayers()){
            if (player.getAccount().getAmount() == 3000){
                winner = player;
                this.view.showWinningPlayer(winner);
                return true;
            }
        }
        return false;
    }

    public GameContext getContext(){
        return model.getContext();
    }

    // Returns the position corresponding to the dice throw.
    // e.g. [2,5] returns 7
    private int calculateFieldPosition(Die[] dice){
        int roll = 0;

        for (Die die : dice) {
            roll += die.getValue();
        }
        return roll;
    }

    // Puts the currentPlayer in the GameContext to the field
    // at the specified position.
    private boolean putPlayerOnField(Player player, Field field){
        if(player == null || field == null)
            return false;

         return field.addPlayer(player);
    }

    // Removes the currentPlayer in the GameContext from the field
    // at the specified position.
    private boolean removePlayerFromField(Player player, Field field){
        if(player == null || field == null)
            return false;

        return field.removePlayer(player);
    }

    // Applies all the field effects to the player.
    private boolean applyFieldEffects(Field field){
        if(field == null)
            return false;

        return field.applyFieldEffects();
    }

    // Returns the field which contains the specified player.
    private Field findFieldWithPlayer(Player player){
        for(Field field: model.getFields().values()){
            if(field.hasPlayer(player)){
                return field;
            }
        }
        return null;
    }
}
