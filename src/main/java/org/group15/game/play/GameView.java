package org.group15.game.play;

import org.group15.player.Player;

public interface GameView {
    public void showPlayerInfo(Player player);
    public void showField(Field field);
    public void showWinningPlayer(Player player);
}
