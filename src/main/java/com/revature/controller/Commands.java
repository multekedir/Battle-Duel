package com.revature.controller;


import com.revature.entities.Combatant;

import java.util.ArrayList;
import java.util.Scanner;

public class Commands {

    public static Scanner scan;

    public static String getInput(String command) {
        Scanner scan;
        scan = new Scanner(System.in);
        System.out.print(command + " >> ");
        String choice = scan.next();
        return choice;
    }

    public static String printCommands() {
        String com = "Help -> to print list of commands  \nGo -> to move around rooms \nDuel -> fight an enemy";
        return com;
    }

    public static void go() {
        Controller.currentRoomDescription();
        Controller.printDirections();
        String input = getInput(" to move around");
        switch (input.toLowerCase()) {
            case "east":
                Controller.goEast();
                break;
            case "west":
                Controller.goWest();
                break;
            case "north":
                Controller.goNorth();
                break;
            case "south":
                Controller.goSouth();
                break;
            case "back":
                Controller.goBack();
                break;
            default:
                System.out.println("Command not found");
        }
    }

    public static void where() {
        Controller.currentRoomDescription();
    }

    public static void duel() {
        //TODO fight
        System.out.println("fighting");
    }

    public static boolean keepGoing() {
        if (allEnemiesAlive() == true && !FightController.hero.isDead()) {
            return true;
        }
        System.out.println("All are dead" + FightController.hero.isDead());
        return false;
    }

    private static boolean allEnemiesAlive() {
        ArrayList<Boolean> alivEnemies = new ArrayList<Boolean>();
        for (Combatant enemy : FightController.enemies) {
            alivEnemies.add(!enemy.isDead());
        }

        for (boolean value : alivEnemies) if (value) return true;
        return false;
    }

    public static void whoWon() {
        if (!FightController.hero.isDead() && !allEnemiesAlive()) {
            System.out.println(FightController.hero.getName() + "is a Hero. You have captured all the bandits.");
        } else if (FightController.hero.isDead() && allEnemiesAlive()) {
            System.out.println("The Enemies have succeeded");
        }

    }

    public static void heal() {
        if (Controller.healHero())
            System.out.println("Hero has been healed. Hero Health -> " + Controller.hero.getHealth());
    }
}
