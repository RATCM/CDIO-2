package org.group15.player;

public class Account {
    private int amount;
    private final int maxAmount;

    public Account(int initAmount) {
        this.maxAmount = 3000;
        this.amount = Math.clamp(initAmount, 0, maxAmount);
    }

    public Account(int initAmount, int maxAmount) {
        this.maxAmount = maxAmount;
        this.amount = Math.clamp(initAmount, 0, maxAmount);
    }

    public int getAmount() {
        return amount;
    }

    public boolean addAmount(int amountToAdd) {
        // addAmount fails if amountToAdd is negative
        if(amountToAdd < 0){
            return false;
        }

        // addAmount fails if amount is at the maximum
        // and amountToAdd is above zero
        if (this.amount >= this.maxAmount && amountToAdd > 0 ) {
            return false;
        }

        // If nothing fails, we modify the amount and return true
        this.amount = Math.clamp(this.amount + amountToAdd, 0, this.maxAmount);
        return true;
    }

    public boolean removeAmount(int amountToRemove) {
        // addAmount fails if amountToRemove is negative
        if(amountToRemove < 0){
            return false;
        }

        // removeAmount fails if amount is at the minimum
        // and amountToRemove is above zero
        if (this.amount == 0 && amountToRemove > 0 ) {
            return false;
        }

        // If nothing fails, we modify the amount and return true
        amount = Math.clamp(this.amount - amountToRemove, 0, this.maxAmount);
        return true;
    }
}
