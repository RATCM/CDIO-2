package org.group15.player;

public class Account {
    private int amount;
    private final int maxAmount;

    public Account(int initAmount) {
        this.amount = Math.max(initAmount, 0);
        this.maxAmount = 3000;
    }

    public Account(int initAmount, int maxAmount) {
        this.amount = Math.max(initAmount, 0);
        this.maxAmount = maxAmount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean addAmount(int amountToAdd) {
        if (amount >= maxAmount && amountToAdd > 0 ) {
            return false;
        }
        if (amountToAdd > 0 && amount + amountToAdd <= maxAmount) {
            amount += amountToAdd;
            return true;
        } else if (amountToAdd > 0) {
            amount = maxAmount;
            return true;
        }
        return false;
    }

    public boolean removeAmount(int amountToRemove) {
        if(amountToRemove > 0 && amountToRemove <= amount) {
            amount -= amountToRemove;
            return true;
        }
        return false;
    }
}
