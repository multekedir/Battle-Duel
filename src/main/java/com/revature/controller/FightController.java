package com.revature.controller;

import com.revature.entities.Attack;
import com.revature.entities.Combatant;
import com.revature.entities.Weapon;

import java.util.ArrayList;
import java.util.List;

public class FightController {
    private static final List<Attack.Weapons> listOfWeapons = Attack.getWeapon();
    static Combatant hero;
    static Combatant enemy;
    static List<Combatant> enemys;
    static Combatant bossEnemy;

    static {
        enemys = new ArrayList<Combatant>();
    }

    public static void printWeapons() {
        int i = 0;
        for (Attack.Weapons w : listOfWeapons) {
            i++;
            System.out.println(i + " -> " + w + " -> " + Attack.weaponsDetails(w));
        }
    }

    public static void fight(Combatant e) {
        int choice;
        while (!e.isDead() || !hero.isDead()) {
            printWeapons();
            choice = Integer.parseInt(Commands.getInput("Pick a weapon")) - 1;
            Weapon.pickWeapon(listOfWeapons.get(choice));
            hero.attack(e, hero.calculateDamage(false));
            e.attack(hero, e.calculateDamage(true));

        }
    }

    public boolean createHero(String name) {
        Commands.getInput("Enter Hero Name");
        hero = new Combatant(name);
        return hero != null;
    }

    public void createEnemy() {
        bossEnemy = new Combatant("Soapy", true);
        Weapon.pickWeapon(Weapon.Weapons.Whitworth);
    }
}
