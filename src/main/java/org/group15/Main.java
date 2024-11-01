package org.group15;
import org.group15.game.play.GameController;
import org.group15.player.Player;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("How many players?");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Player " + (i + 1) + ", name: ");
            String name = sc.next();
            players[i] = new Player(i , name);
        }

        GameController gc = new GameController(players);

        while (!gc.checkForWinner()) {
            System.out.println(gc.getContext().getCurrentPlayer().getName() + " Press enter to Roll!");

            gc.rollDice();

        }

        gc.displayWinningPlayer();

    }
}