package org.group15.player;

public class Player {
    private final int id;
    private final String name;
    private final Account account;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.account = new Account(1000);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

}
