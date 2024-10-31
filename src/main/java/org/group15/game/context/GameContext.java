package org.group15.game.context;

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

    // TODO
    //switches game state
    public void setState(GameState newState) {

    }
    // TODO
    public void setDefaultState() {

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
    // TODO
    public void setCurrentPlayer(Player currentPlayer) {

    }




}