package org.group15.game.play;

import org.group15.effects.Effect;
import org.group15.player.Player;

import java.util.ArrayList;

public class Field {
    public int position;
    public String description;
    ArrayList<Player> playersOnField;
    private Effect[] effects;

    // TODO
    public Field(Effect[] effects, int position){

    }

    // TODO
    // add player to list
    // return true if successful, else false
    public boolean addPlayer(Player player){
        return false;
    }

    // TODO
    // remove player from list
    // return true if successful, else false
    public boolean removePlayer(Player player){
        return false;
    }

    // TODO
    // Whether or not the array contains the player
    public boolean hasPlayer(Player player){
        return false;
    }

    // TODO
    // applies the field effects to the player
    // return true if successful, else false
    public boolean applyFieldEffects(Player player){
        return false;
    }
}
