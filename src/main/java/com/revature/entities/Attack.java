package com.revature.entities;

import java.util.Random;

public abstract class Attack extends Weapon {


    private boolean isFar;

    public void attack(Combatant obj, int damage) {
        System.out.println("Attacking " + obj.getName() + " with " + obj.getWeaponName());
        if (obj.getHealth() - damage <= 0) {
            obj.setHealth(0);
            obj.setDead(true);
        } else {
            obj.setHealth(obj.getHealth() - damage);
        }
    }

    public Integer calculateDamage() {
        Random rn = new Random();
        int damage = this.isFar ? (strength) + (distance) + accuracy / 6 : (strength) + (distance / 2) + accuracy / 2;

        damage = damage * rn.nextInt(10) + 1;
        // returning that value
        return damage;
    }

    public String isFar() {
        return isFar ? "is far" : "is close";
    }

    public void setFar(boolean far) {
        this.isFar = far;
    }

    public boolean getIsFar() {
        return this.isFar;
    }

    @Override
    public String toString() {
        return "Attack{} " + super.toString() + "Weapon{} " + strength + distance + accuracy;
    }


}
