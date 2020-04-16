package com.revature.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Weapon {
    protected int strength;
    protected int accuracy;
    protected int distance;
    private String name;

    public static List<Weapons> getWeapon() {
        List<Weapons> w = Arrays.asList(Weapons.values());
        return w;
    }

    public static String weaponsDetails(Weapons weapon) {
        switch (weapon) {
            case Revolver:
                return "Ability for quick draw during dull. Best for close range fight";
            case Whitworth:
                return "Highly powered";
            case Winchester:
                return "Accurate ";
            default:
                return "Invalid weapon";
        }
    }

    public void setWeapon(Weapons weapon) {
        switch (weapon) {
            case Revolver:
                this.name = "Revolver";
                strength = 5;
                accuracy = 3;
                distance = 2;
                break;
            case Winchester:
                this.name = "Winchester";
                strength = 6;
                accuracy = 2;
                distance = 2;
                break;
            case Whitworth:
                this.name = "Whitworth";
                strength = 2;
                accuracy = 5;
                distance = 3;
                break;
            default:
                break;
        }

    }

    public String getWeaponName() {
        return name;
    }

    public enum Weapons {
        Revolver, Winchester, Whitworth;

        public static Weapons getRandomWeapons() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}