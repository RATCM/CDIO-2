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

    // TODO
    public GameController(Player[] player){
        this.model = new GameModel(player);
        this.view = new SimpleGameView(new Scanner(System.in));
        this.diceController = new DiceController(2,6);

    }

    // TODO
    // Used if you wanna use a different GameView instead
    // of the default one
    public GameController(Player[] player, GameView view){
        this.model = new GameModel(player);
        this.view = view;
        this.diceController = new DiceController(2,6);
    }

    // TODO
    // Calls the getUserRoll method in DiceController
    // And updates the game context
    public void rollDice(){
        int roll = calculateFieldPosition(diceController.retrieveUserRoll().getDice());

        removePlayerFromField();

        putCurrentPlayerOnField(roll-1);

        applyFieldEffectsToCurrentPlayer(roll-1);

        showField();

        model.getContext().doNextPlayerTurn();

    }

    // TODO
    // Displays the field description to the player
    // through the GameView interface
    public void showField(){
        view.showField(findFieldWithPlayer(model.getContext().getCurrentPlayer()));

    }

    // TODO
    // Returns whether some player has won.
    public boolean checkForWinner(){
        for(Player player: model.getContext().getAllPlayers()){
            if (player.getAccount().getAmount() == 3000){
                return true;
            }

        }
        return false;
    }

    // TODO
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

    // TODO
    // Returns the position corresponding to the dice throw.
    // e.g. [2,5] returns 7
    private int calculateFieldPosition(Die[] dice){
        int roll = 0;

        for(int i = 0; i < dice.length; i++){
            roll += dice[i].getValue();
        }
        return roll -1;
    }

    // TODO
    // Puts the currentPlayer in the GameContext to the field
    // at a the specified position.
    private boolean putCurrentPlayerOnField(int position){
         Field field = model.getFields()[position];

         field.addPlayer(model.getContext().getCurrentPlayer());

        return false;
    }

    // TODO
    // Removes the currentPlayer in the GameContext from the field
    // at a the specified position.
    private boolean removePlayerFromField(){
        for(Field field : model.getFields()){
            if(field.hasPlayer(model.getContext().getCurrentPlayer())){
                field.removePlayer(model.getContext().getCurrentPlayer());
            }
        }

        return false;
    }

    // TODO
    // Applies all the field effects to the player.
    private void applyFieldEffectsToCurrentPlayer(int roll){
        this.model.getFields()[roll].applyFieldEffects();


    }

    // TODO
    // Returns the field which contains the specified player.
    private Field findFieldWithPlayer(Player player){
        for(Field field: model.getFields()){
            if(field.hasPlayer(player)){
                return field;
            }
        }
        return null;
    }
}
