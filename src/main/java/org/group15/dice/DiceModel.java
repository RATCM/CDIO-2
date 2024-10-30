package org.group15.dice;

public class DiceModel {
    private Die[] dice;

    public DiceModel(Die[] dice) {
        this.dice = dice;
    }

    public Die[] getDice() {
        return this.dice;
    }
}