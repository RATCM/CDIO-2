package org.group15.game.play;

import org.group15.game.context.GameContext;
import org.group15.player.Player;
import org.group15.game.effects.*;

public class GameModel {
    private GameContext gameContext;
    private Field[] fields = new Field[11];

    // TODO
    GameModel(Player[] players) {
        this.gameContext = new GameContext(players);

        this.fields[0] = new Field(new Effect[]{new PointChangeEffect(250,gameContext)}, 2);
        this.fields[0].description = "Climbed a tall tower and found a tresure Chest" + System.lineSeparator();

        this.fields[1] = new Field(new Effect[]{new PointChangeEffect(-100,gameContext)}, 3);
        this.fields[1].description = "Fell into a crator" + System.lineSeparator();

        this.fields[2] = new Field(new Effect[]{new PointChangeEffect(100,gameContext)}, 4);
        this.fields[2].description = "Went through the palace gates" + System.lineSeparator();

        this.fields[3] = new Field(new Effect[]{new PointChangeEffect(-20,gameContext)}, 5);
        this.fields[3].description = "Got stuck in a cold dessert" + System.lineSeparator();

        this.fields[4] = new Field(new Effect[]{new PointChangeEffect(180,gameContext)}, 6);
        this.fields[4].description = "Found safety in a Walled of city" + System.lineSeparator();

        this.fields[5] = new Field(new Effect[]{new PointChangeEffect(0,gameContext)}, 7);
        this.fields[5].description = "Found peace in the local monastery" + System.lineSeparator();

        this.fields[6] = new Field(new Effect[]{new PointChangeEffect(-70,gameContext)}, 8);
        this.fields[6].description = "Got stuck in a black cave" + System.lineSeparator();

        this.fields[7] = new Field(new Effect[]{new PointChangeEffect(60,gameContext)}, 9);
        this.fields[7].description = "Found a small hut in the mountains" + System.lineSeparator();

        this.fields[8] = new Field(new Effect[]{new PointChangeEffect(-80,gameContext), new ExtraTurnEffect(gameContext)}, 10);
        this.fields[8].description = "Encounterd a wall of werewolfs and got bit" + System.lineSeparator();

        this.fields[9] = new Field(new Effect[]{new PointChangeEffect(-50,gameContext)}, 11);
        this.fields[9].description = "Fell into a deep pit" + System.lineSeparator();

        this.fields[10] = new Field(new Effect[]{new PointChangeEffect(650,gameContext)}, 12);
        this.fields[10].description = "Dug deep a hit GOLD!!!!!" + System.lineSeparator();

    }

    // TODO
    public GameContext getContext() {
        return gameContext;
    }

    // TODO
    public Field[] getFields () {
        return fields;
    }

}
