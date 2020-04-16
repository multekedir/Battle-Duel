package com.revature.entities;

public class Combatant extends Attack implements Heal {

    private int health;
    private String name;
    private boolean isDead;
    private boolean isVillain;
    private static final int MAX_heal = 2;
    private int count;

    public Combatant(String name, boolean isVillain) {
        this.count = 0;
        this.name = name;
        this.health = 100;
        this.isVillain = isVillain;
        this.isDead = false;
    }

    public Combatant(String name) {
        this.name = name;
        this.health = 100;
        this.isVillain = false;
        this.isDead = false;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getStatus() {
        return "";
    }

    public String getName() {
        return name;
    }

    public boolean isVillain() {
        return isVillain;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Combatant{" +
                "health=" + health +
                ", name='" + name + '\'' +
                ", isDead=" + isDead +
                ", isVillain=" + isVillain +
                '}';
    }

    public boolean heal() {
        if (!this.isVillain && (count++ < MAX_heal)) {
            this.setHealth(getHealth() + 10);
            return true;
        }
        return false;
    }
}

