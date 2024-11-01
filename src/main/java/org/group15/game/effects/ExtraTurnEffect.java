package org.group15.game.effects;

import org.group15.game.context.ExtraTurnState;
import org.group15.game.context.GameContext;
import org.group15.game.context.GameState;


public class ExtraTurnEffect extends Effect {
    protected GameContext context;

    public ExtraTurnEffect(GameContext context) {
        super(context);
        this.context = context;
    }

    @Override
    public boolean apply() {
        this.context.setState(new ExtraTurnState());
        return true;
    }

    @Override
    public String getDescription() {
        return this.context.getCurrentPlayer().getName() + " gets another turn!";
    }

    @Override
    public Alignment getAlignment() {
        return Alignment.Good;
    } 
}
