package org.group15.game.context;

public class ExtraTurnState extends GameState {

    @Override
    public void doNextTurn(GameContext context) {
        context.setDefaultState();
    }
}
