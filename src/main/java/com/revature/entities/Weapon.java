package com.revature.entities;

import java.util.Arrays;
import java.util.List;

public class Weapon {

    protected static int strength;
    protected static int accuracy;
    protected static int distance;

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

    public static void pickWeapon(Weapons weapon) {
        switch (weapon) {
            case Revolver:
                strength = 5;
                accuracy = 3;
                distance = 2;
                break;
            case Winchester:
                strength = 6;
                accuracy = 2;
                distance = 2;
                break;
            case Whitworth:
                strength = 2;
                accuracy = 5;
                distance = 3;
                break;
            default:
                break;
        }

    }


    public enum Weapons {
        Revolver, Winchester, Whitworth
    }
}