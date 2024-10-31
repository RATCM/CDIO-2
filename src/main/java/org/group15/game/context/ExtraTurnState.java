package org.group15.game.context;

public class ExtraTurnState extends GameState {

    @Override
     void doNextTurn(GameContext context) {
        context.setDefaultState();
    }
}
