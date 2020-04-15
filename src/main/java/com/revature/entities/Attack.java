package com.revature.entities;

import java.util.Random;

public abstract class Attack extends Weapon {


    public void attack(Combatant obj, int damage) {
        if (obj.getHealth() - damage <= 0) {
            obj.setHealth(0);
            obj.setDead(true);
        } else {
            obj.setHealth(-damage);
        }
    }

    public Integer calculateDamage(boolean isFar) {
        Random rdm = new Random();
        int high = isFar ? (strength / 2) + distance + accuracy : (strength) + (distance / 2) + accuracy;
        //get random power
        int damage = (rdm.nextInt(10 - 1) + 1) * high;

        // returning that value
        return damage;
    }

    @Override
    public String toString() {
        return "Attack{} " + super.toString() + "Weapon{} " + strength + distance + accuracy;
    }

    public void makesoud(String sound) {
        System.out.println(sound);
    }


}
