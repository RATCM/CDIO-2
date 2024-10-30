package org.group15.game.context;

public class DefaultState extends GameState {

    @Override
    public void doNextTurn(GameContext context) {
        context.doNextPlayerTurn();
    }
}
