package org.group15.dice;

public class Die {

    private int value;
    private int sides;
    private final java.util.Random random;

    Die(int sides){
        this.sides = sides;
        this.value = -1;
        random = new java.util.Random();
    }

    void roll() {
        this.value = random.nextInt(1,(sides+1));
    }

    public int getValue() {
        return this.value;
    }

}
