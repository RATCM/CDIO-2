package org.group15.game.play;

import org.group15.game.context.GameContext;
import org.group15.player.Player;
import org.group15.game.effects.*;

import java.util.HashMap;

public class GameModel {
    private final GameContext gameContext;
    private final HashMap<Integer, Field> fields = new HashMap<Integer, Field>(11);

    GameModel(Player[] players) {
        this.gameContext = new GameContext(players);

        this.fields.put(2, new Field(new Effect[]{new PointChangeEffect(250,gameContext)}, 2));
        this.fields.get(2).description = "Climbed a tall tower and found a treasure Chest";

        this.fields.put(3, new Field(new Effect[]{new PointChangeEffect(-100,gameContext)}, 3));
        this.fields.get(3).description = "Fell into a crater";

        this.fields.put(4, new Field(new Effect[]{new PointChangeEffect(100,gameContext)}, 4));
        this.fields.get(4).description = "Went through the palace gates";

        this.fields.put(5, new Field(new Effect[]{new PointChangeEffect(-20,gameContext)}, 5));
        this.fields.get(5).description = "Got stuck in a cold dessert";

        this.fields.put(6, new Field(new Effect[]{new PointChangeEffect(180,gameContext)}, 6));
        this.fields.get(6).description = "Found safety in a Walled of city";

        this.fields.put(7, new Field(new Effect[]{new PointChangeEffect(0,gameContext)}, 7));
        this.fields.get(7).description = "Found peace in the local monastery";

        this.fields.put(8, new Field(new Effect[]{new PointChangeEffect(-70,gameContext)}, 8));
        this.fields.get(8).description = "Got stuck in a black cave";

        this.fields.put(9, new Field(new Effect[]{new PointChangeEffect(60,gameContext)}, 9));
        this.fields.get(9).description = "Found a small hut in the mountains";

        this.fields.put(10, new Field(new Effect[]{new PointChangeEffect(-80,gameContext), new ExtraTurnEffect(gameContext)}, 10));
        this.fields.get(10).description = "Encountered a wall of werewolfs and got bit";

        this.fields.put(11, new Field(new Effect[]{new PointChangeEffect(-50,gameContext)}, 11));
        this.fields.get(11).description = "Fell into a deep pit";

        this.fields.put(12, new Field(new Effect[]{new PointChangeEffect(650,gameContext)}, 12));
        this.fields.get(12).description = "Dug deep a hit GOLD!!!!!";

        // We set the default field position of each player
        for(Player player: players) {
            this.fields.get(2).addPlayer(player);
        }
    }

    public GameContext getContext() {
        return gameContext;
    }

    public HashMap<Integer, Field> getFields () {
        return fields;
    }
}
