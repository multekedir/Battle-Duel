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

    }

    public void start() {
        Controller controller = new Controller();
        String[] roomList = {"Stable", "Store", "Road", "null", "Entrance"};
        controller.setup("Multezem");
        Commands.go();

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
