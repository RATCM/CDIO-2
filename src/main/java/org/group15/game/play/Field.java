package org.group15.game.play;

import org.group15.game.effects.Effect;
import org.group15.player.Player;

import java.util.ArrayList;

public class Field {
    public int position;
    public String description;
    ArrayList<Player> playersOnField = new ArrayList<Player>();
    private Effect[] effects;



    public Field(Effect[] effects, int position) {
        this.effects = effects;
        this.position = position;

        StringBuilder effectDescription = new StringBuilder();
        for (Effect effect : effects) {
            effectDescription.append(effect.getDescription());
        }
        this.description = effectDescription.toString();
    }

    // add player to list
    // return true if successful, else false
    public boolean addPlayer(Player player){
        return playersOnField.add(player);
    }


    // remove player from list
    // return true if successful, else false
    public boolean removePlayer(Player player){
        return playersOnField.remove(player);
    }


    // Whether or not the array contains the player
    public boolean hasPlayer(Player player){
        return playersOnField.contains(player);
    }


    // applies the field effects to the player
    // return true if successful, else false
    public boolean applyFieldEffects(){
        boolean result = true;

        for (Effect effect : effects){
            if (!effect.apply()){
                result = false;
            };
        }

        return result;
    }
}
