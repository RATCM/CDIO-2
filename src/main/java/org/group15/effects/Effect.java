package org.group15.effects;
import org.group15.game.context.GameContext;

public abstract class Effect {
    protected GameContext context;

    protected Effect(GameContext context) {
        this.GameContext = context;
    }

    public abstract void apply();
    public abstract String getDescription();
    public abstract Alignment getAlignment();
}
