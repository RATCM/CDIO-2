package org.group15.game.play;

import org.group15.dice.DiceController;
import org.group15.dice.Die;
import org.group15.player.Player;

public class GameController {
    private GameView view;
    private GameModel model;
    private DiceController diceController;

    // TODO
    public GameController(Player[] player){

    }

    // TODO
    // Used if you wanna use a different GameView instead
    // of the default one
    public GameController(Player[] player, GameView view){

    }

    // TODO
    // Calls the getUserRoll method in DiceController
    // And updates the game context
    public void rollDice(){

    }

    // TODO
    // Displays the field description to the player
    // through the GameView interface
    public void showField(){

    }

    // TODO
    // Returns whether some player has won.
    public boolean checkForWinner(){
        return false;
    }

    // TODO
    // Displays the winning player through the
    // GameView interface
    public boolean displayWinningPlayer(){
        return false;
    }

    // TODO
    // Returns the position corresponding to the dice throw.
    // e.g. [2,5] returns 7
    private int calculateFieldPosition(Die[] dice){
        return -1;
    }

    // TODO
    // Puts the currentPlayer in the GameContext to the field
    // at a the specified position.
    private boolean putCurrentPlayerOnField(int position){
        return false;
    }

    // TODO
    // Removes the currentPlayer in the GameContext from the field
    // at a the specified position.
    private boolean removePlayerFromField(){
        return false;
    }

    // TODO
    // Applies all the field effects to the player.
    private void applyFieldEffectsToCurrentPlayer(){

    }

    // TODO
    // Returns the field which contains the specified player.
    private Field findFieldWithPlayer(Player player){
        return null;
    }
}
