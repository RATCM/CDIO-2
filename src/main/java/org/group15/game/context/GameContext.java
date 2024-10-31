package org.group15.game.context;
import org.group15.player.Player;

public class GameContext {
    private GameState state;
    private Player[] players;
    private Player currentplayer;

    //constructor, uses 1st player in array as default
    public GameContext(Player[] players) {
        this.players = players;
        this.currentplayer = players[0];
        this.state = new DefaultState();
    }

    //switches game state
    public void setState(GameState newState) {
        this.state = newState;

    }


    public void setDefaultState() {
        this.state = new DefaultState();

    }

    public GameState getState() {
        return this.state;
    }

    public void doNextPlayerTurn() {
        state.doNextTurn(this);
    }

    public Player[] getAllPlayers() {
        return this.players;
    }

    public Player getCurrentPlayer() {
        return this.currentplayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentplayer = currentPlayer;
    }




}