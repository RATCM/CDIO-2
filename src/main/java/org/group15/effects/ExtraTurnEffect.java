package org.group15.effects;

import org.group15.game.context.GameContext;
import org.group15.player.Player;


// Needs fixing
public class ExtraTurnEffect extends Effect {

    public ExtraTurnEffect(GameContext context) {
        this.context = context;
    }

    public void apply() {
        ExtraTurnState.doNextTurn(this.context);
    }
    public String getDescription() {
        Player thisPlayer = this.context.getCurrentPlayer();
        return thisPlayer.getName() + " gets another turn!";
    }
    public Alignment getAlignment() {
        return Alignment.Good;
    } 
}
