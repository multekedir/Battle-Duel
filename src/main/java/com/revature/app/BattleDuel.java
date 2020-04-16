package com.revature.app;


import com.revature.controller.Commands;
import com.revature.controller.Controller;
import com.revature.entities.Combatant;

import java.util.Scanner;

public class BattleDuel {
    public Scanner scan;
    Combatant hero;

    public static void main(String[] args) {
        BattleDuel m = new BattleDuel();
        m.start();
//        Commands.scan.close();

    }

    public void start() {
        Controller controller = new Controller();

        controller.setup();
        Commands.where();
        do {
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '*'));
            String com = Commands.getInput("Enter a Command. \"Help\" -> Print list of commands");
            switch (com.toLowerCase()) {
                case "go":
                    Commands.go();
                    break;
                case "help":
                    System.out.println(Commands.printCommands());
                    break;
                case "heal":
                    Commands.heal();
                    break;
                case "quit":
                    System.out.println(":(");
                    break;
                default:
                    System.out.println("Command not found");
                    System.out.println(Commands.printCommands());
            }

        } while (Commands.keepGoing());
        Commands.whoWon();
        System.out.println("Hello");


//        controller.creatRoom()


//        scan = new Scanner(System.in);
//        System.out.println("Welcome to Battle Duel!");
//
//        boolean userIsPlaying = true;
//        System.out.println("Enter Hero name");
//        String choice = scan.nextLine();
//        hero = new Combatant(choice);
//        hero.pickWeapon("Winchester");
//        System.out.println(hero.getWeapon());
//        System.out.println(hero.calculateDamage(true));

//        while (userIsPlaying) {
//            //userIsPlaying = gameLoop();
//        }
//
//        System.out.println("Thanks for playing!");
//
//        // you ALWAYS want to make sure that you close your resources
        // in this case, the Scanner is the resource that needs closed
//        scan.close();


    }

}
