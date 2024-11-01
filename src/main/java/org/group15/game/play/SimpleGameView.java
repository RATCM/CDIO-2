package org.group15.game.play;

import org.group15.player.Player;

import java.util.Scanner;

public class SimpleGameView implements GameView {
    Scanner scanner;

    SimpleGameView(Scanner scanner) {
        this.scanner = scanner;
    }

    // TODO
    @Override
    public void showField(Field field) {
        System.out.println("Position: " + field.position + System.lineSeparator()
                            + "Effects: " + field.description + System.lineSeparator());
    }

    // TODO
    @Override
    public void showWinningPlayer(Player player) {
        System.out.println("Player: " + player + " wins!");
    }
}
