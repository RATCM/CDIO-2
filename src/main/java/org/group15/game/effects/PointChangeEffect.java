package org.group15.game.effects;
import org.group15.game.context.GameContext;


public class PointChangeEffect extends Effect{
    private final int amount;
    protected GameContext context;

    public PointChangeEffect(int amount, GameContext context) {
        super(context);
        this.amount = amount;
        this.context = context;
    }

    @Override
    public boolean apply() {
        if (amount > 0) {
            return this.context.getCurrentPlayer().getAccount().addAmount(amount);
        } else {
            return this.context.getCurrentPlayer().getAccount().removeAmount(-amount);
        }
    }

    @Override
    public String getDescription() {
        if(amount > 0){
            return String.format("Adds %d points to player", amount);
        }
        else if (amount < 0){
            return String.format("Removes %d points to player", -amount);
        }

        return "No points added or removed";
    }

    @Override
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
