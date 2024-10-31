package org.group15.dice;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Die {

    private int value;
    private int sides;
    private final RandomGenerator random;

    Die(int sides){
        this.sides = sides;
        this.value = -1;
        random = new Random();
    }

    Die(int sides, RandomGenerator random){
        this.sides = sides;
        this.value = -1;
        this.random = random;
    }

    void roll() {
        this.value = random.nextInt(1,(sides+1));
    }

    public int getValue() {
        return this.value;
    }

}
