package org.group15.effects;
import org.group15.game.context.GameContext;


public class PointChangeEffect extends Effect{
    private int amount;
    protected GameContext context;

    public PointChangeEffect(int amount, GameContext context) {
        super(context);
        this.amount = amount;
        this.context = context;
    }

    public void apply() {
        if (amount > 0) {
            this.context.getCurrentPlayer().getAccount().addAmount(amount);
        } else {
            this.context.getCurrentPlayer().getAccount().removeAmount(-amount);
        }
    }

    public String getDescription() {
        if (amount > 0) {
            return "Adds " + amount + " points to player " + this.context.getCurrentPlayer() + "'s account";
        } else if (amount < 0) {
            return "Removes " + amount + " points from player " + this.context.getCurrentPlayer() + "'s account";
        } else {
            return "no points added or removed";
        }
    }

    public Alignment getAlignment() {
        if (amount > 0) {
            return Alignment.Good;
        } else if (amount == 0) {
            return Alignment.Neutral;
        } else {
            return Alignment.Bad;
        }
    } 
}
