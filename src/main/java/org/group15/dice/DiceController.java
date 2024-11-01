package org.group15.dice;

import java.util.Scanner;

public class DiceController {

    private DiceView view;
    private DiceModel dice;

    
    public DiceController(int numDice, int numSides, Scanner scanner) {
        view = new SimpleDiceView(scanner);
        var diceArray = new Die[numDice];
        for (int i = 0 ; i < numDice ; i++) {
            diceArray[i] = new Die(numSides);
        }
        dice = new DiceModel(diceArray); 
    }

    
    public DiceModel retrieveUserRoll() {
        view.getUserRoll();
        this.rollDice();
        view.displayRollResult(this.dice.getDice());
        return dice;
    }

    
    private void rollDice() {
        var allDice = this.dice.getDice();
        for (int i = 0 ; i < allDice.length ; i++) {
            allDice[i].roll();
        }
    }
}