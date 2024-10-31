package org.group15.game.context;
import org.group15.player.Player;

public class DefaultState extends GameState {

    @Override
    public void doNextTurn(GameContext context) {
        int currPlayerID = context.getCurrentPlayer().getId();
        Player[] allPlayers = context.getAllPlayers();

        if (currPlayerID + 1 == allPlayers.length) {
            context.setCurrentPlayer(allPlayers[0]);
        }else context.setCurrentPlayer(allPlayers[currPlayerID+1]);

    }
}
