package org.group15.game.play;

import org.group15.game.effects.Effect;
import org.group15.player.Player;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Field {
    public int position;
    public String description;
    private final HashSet<Player> playersOnField = new HashSet<>(); // We use HashSet to ensure any field doesn't have duplicates
    private final Effect[] effects;

    public Field(Effect[] effects, int position) {
        this.effects = effects;
        this.position = position;
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


    // Whether the array contains the player
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
            }
        }

        return result;
    }

    public String getDescription(){
        var effectDescriptions = Arrays.stream(effects) // Makes the effects array into a stream of effects
                .map(Effect::getDescription) // Maps the effect description to a new stream of strings
                .collect(Collectors.joining(System.lineSeparator())); // Joins the strings

        return description + System.lineSeparator() + effectDescriptions;
    }

}
