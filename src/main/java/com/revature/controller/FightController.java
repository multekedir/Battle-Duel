package com.revature.controller;

import com.revature.entities.Attack;
import com.revature.entities.Combatant;
import com.revature.entities.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightController {
    /**
     * list weapons from the enum
     */
    private static final List<Attack.Weapons> listOfWeapons = Attack.getWeapon();
    /**
     * The Hero.
     */
    static Combatant hero;
    /**
     * The list of Enemies.
     */
    static List<Combatant> enemies;
    private static Random rd;
    private static int numfights;


    static {
        enemies = new ArrayList<Combatant>();
    }

    public static void printWeapons() {
        int i = 0;
        for (Attack.Weapons w : listOfWeapons) {
            System.out.println(++i + " -> " + w + " -> " + Attack.weaponsDetails(w));
        }
    }


    private static boolean isFar() {
        rd = new Random();
        return rd.nextBoolean();
    }

    private static Attack.Weapons pickWeapon() {
        boolean weaponPicked = false;
        int choice;
        Attack.Weapons weaponChoice = null;
        while (!weaponPicked) {
            printWeapons();
            choice = Integer.parseInt(Commands.getInput("Pick a weapon")) - 1;
            try {
                weaponChoice = listOfWeapons.get(choice);
                weaponPicked = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Not valid");
            }
        }
        return weaponChoice;

    }

    public static boolean healHero() {
        if (hero != null) {
            return hero.heal();
        }
        return false;
    }

    /**
     * Makes enemy and hero fight until one is dead
     *
     * @param enemy the enemy
     * @return true if hero won
     */
    public static boolean fight(Combatant enemy) {
        List<Combatant> e = enemies;
        // return true if hero won
        System.out.printf("Hero Health -> %s Enemy Health -> %s", hero.getHealth(), enemy.getHealth());
        while (!enemy.isDead() && !hero.isDead()) {
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '*'));
            //get weapon for hero
            hero.setWeapon(pickWeapon());
            //hero turn
            hero.setFar(enemy.getIsFar());
            System.out.println(new String(new char[100]).replace('\0', '*'));
            hero.attack(enemy, hero.calculateDamage());
            //enemy turn
            if (!enemy.isDead()) {
                enemy.attack(hero, enemy.calculateDamage());
            } else {
                System.out.println(enemy.getName() + " is dead");
            }


            System.out.println("Hero Health -> " + hero.getHealth() + " Enemy Health -> " + enemy.getHealth());
        }
        //rest number of heals after two fights
        numfights++;
        if (numfights > 1) {
            System.out.println("You can get healed");
            hero.setCount(0);
        }

        return !hero.isDead();
    }

    public boolean createHero() {
        String name = Commands.getInput("Enter Hero Name");
        hero = new Combatant(name);
        return hero != null;
    }

    public void createEnemy() {

        //create enemy with a random far
        Combatant enemy1 = new Combatant("Curly Bill Brocius", true);
        Combatant enemy2 = new Combatant("Ike Clanton", true);
        Combatant enemy3 = new Combatant("Johnny Tyler", true);
        Combatant enemy4 = new Combatant("Johnny Ringo", true);

        //add enemies to a list
        enemies.add(enemy1);
        enemies.add(enemy2);
//        enemies.add(enemy3);
//        enemies.add(enemy4);

        //give enemy random weapon
        for (Combatant en : enemies) {
            Weapon.Weapons rand = Attack.Weapons.getRandomWeapons();
            en.setWeapon(rand);
            en.setFar(isFar());
        }

    }

}
