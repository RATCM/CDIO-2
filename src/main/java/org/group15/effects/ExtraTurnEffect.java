package org.group15.effects;

import org.group15.game.context.GameContext;
import org.group15.player.Player;


public class ExtraTurnEffect extends Effect {
    protected GameContext context;

    public ExtraTurnEffect(GameContext context) {
        super(context);
        this.context = context;
    }

    public void apply() {
        ExtraTurnState.doNextTurn(this.context);
    }
    public String getDescription() {
        return this.context.getCurrentPlayer().getName() + " gets another turn!";
    }
    public Alignment getAlignment() {
        return Alignment.Good;
    } 
}
