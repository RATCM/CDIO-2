package org.group15.game.play;

import org.group15.player.Player;

import java.util.Scanner;

public class SimpleGameView implements GameView {
    Scanner scanner;

    SimpleGameView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void showPlayerInfo(Player player) {
        System.out.println("-- Player --");
        System.out.printf("Name: %s%s", player.getName(), System.lineSeparator());
        System.out.printf("Points: %d%s", player.getAccount().getAmount(), System.lineSeparator());
        System.out.println("-----------");
        System.out.println();
    }

    @Override
    public void showField(Field field) {
        System.out.println("-- Effects --");
        System.out.println(field.getDescription());
        System.out.println("-------------");
        System.out.println();
    }

    @Override
    public void showWinningPlayer(Player player) {
        System.out.println("Player: " + player.getName() + " wins!");
    }
}
