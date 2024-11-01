package org.group15;
import org.group15.game.play.GameController;
import org.group15.player.Player;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var players = getPlayers(sc);
        GameController gc = new GameController(players, sc);


        while (!gc.checkForWinner()) {
            System.out.printf("%s's turn%s", gc.getContext().getCurrentPlayer().getName(), System.lineSeparator());

            gc.rollDice();

        }

        gc.displayWinningPlayer();

    }

    private static Player[] getPlayers(Scanner scanner) {
        System.out.println("How many players?");

        int n = Integer.parseInt(scanner.nextLine());
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Player " + (i + 1) + ", name: ");
            String name = scanner.nextLine();
            players[i] = new Player(i , name);
        }
        System.out.println("--------------------");

        return players;
    }
}