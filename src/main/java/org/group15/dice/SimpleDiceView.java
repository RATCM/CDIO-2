package org.group15.dice;
import java.util.Scanner;

public class SimpleDiceView implements DiceView {
    Scanner scanner;

    public SimpleDiceView(Scanner scanner) {
        this.scanner = scanner;
    }

    //prompts user for input and pauses for 1 second then returns
    public void getUserRoll() {
        System.out.println("Press enter to roll your dice.");
        scanner.nextLine();
        for (int i = 0 ; i < 10  ; i++) {
            System.out.print(". ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public void displayRollResult(Die[] dice) {
        for (var d : dice) {
            System.out.println("You rolled: " + d.getValue());
        }
    }

}
