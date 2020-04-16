package com.revature.controller;

import com.revature.entities.Combatant;
import com.revature.entities.rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * The type Controller.
 */
public class Controller extends FightController {
    private static Room current;
    private static Room previous;
    private static List<Room> rooms;
    private boolean isSetup = false;

    /**
     * Print directions.
     */
    public static void printDirections() {
        System.out.print("Use the command");
        for (Directions d : Directions.values()) {
            System.out.print(" " + d);
        }
    }

    /**
     * Go north.
     */
    public static void goNorth() {
        if (current.getNorthRoom() != null) {
            System.out.println("Going North");
            changePrevious(current);
            changeCurrent(current.getNorthRoom());
        } else {
            System.out.println("Can't Go, there is a wall");
        }
    }

    /**
     * Go south.
     */
    public static void goSouth() {
        if (current.getSouthRoom() != null) {
            System.out.println("Going South");
            changePrevious(current);
            changeCurrent(current.getSouthRoom());
        } else {
            System.out.println("Can't Go, there is a wall");
        }
    }

    /**
     * Go east.
     */
    public static void goEast() {
        if (current.getEastRoom() != null) {
            System.out.println("Going East");
            changePrevious(current);
            changeCurrent(current.getEastRoom());

        } else {
            System.out.println("Can't Go, there is a wall");
        }
    }

    /**
     * Go west.
     */
    public static void goWest() {
        if (current.getWestRoom() != null) {
            System.out.println("Going West");
            changePrevious(current);
            changeCurrent(current.getWestRoom());
        } else {
            System.out.println("Can't Go, there is a wall");
        }
    }

    /**
     * change the previous room
     */
    private static void changePrevious(Room room) {
        previous = room;
    }

    /**
     * change the Current room
     */
    private static void changeCurrent(Room room) {
        current = room;
        current.getDescription();
        System.out.println(new String(new char[100]).replace('\0', '*'));
        if (room.hasEnemy() && !room.getEnemy().isDead()) {
            Combatant enemy = room.getEnemy();
            System.out.println(enemy.getName() + " is there. Prepare to Fight. \nHe is carrying " + enemy.getWeaponName() + " and he " + enemy.isFar());
            fight(room.getEnemy());

//            System.out.println(fight(room.getEnemy()) ? "Hero" : "Enemy");
        }
    }

    /**
     * Go back to the previous room
     */
    public static void goBack() {
        System.out.println("Going back");
        current = previous;
        current.getDescription();
    }

    /**
     * Current room description.
     */
    public static void currentRoomDescription() {
        current.getDescription();
    }

    /**
     * Sets .
     */
    public void setup() {
        rooms = new ArrayList<Room>();
        current = new Room("Entrance");
        rooms.add(current);
        isSetup = true;

        // setup rooms
        creatRoom("Entrance", "Store", Directions.EAST);
        creatRoom("Entrance", "Road", Directions.NORTH);
        creatRoom("Entrance", "Church", Directions.WEST);

        creatRoom("Road", "School", Directions.WEST);
        creatRoom("Road", "Stable", Directions.EAST);
        creatRoom("Road", "Dueling  Area", Directions.NORTH);

        creatRoom("Dueling  Area", "Bar", Directions.EAST);
        creatRoom("Dueling  Area", "Sheriff's Office", Directions.WEST);


        createHero();
        createEnemy();
        addEnemyToRoom();
        System.out.println(fight(enemies.get(1)) ? "Hero Won" : "Enemy Won");


    }

    /**
     * Creat room boolean.
     *
     * @param oldRoom   the old room
     * @param name      the name
     * @param direction the direction
     * @return the boolean
     */
    public boolean creatRoom(String oldRoom, String name, Directions direction) {
        Room newRoom = new Room(name);
        Room room = this.traverse(oldRoom);
        if (isSetup) {
            if (room != null) {
                switch (direction) {
                    case EAST:
                        room.setEastRoom(newRoom);
                        newRoom.setWestRoom(current);
                        break;
                    case WEST:
                        room.setWestRoom((newRoom));
                        newRoom.setEastRoom(current);
                        break;
                    case SOUTH:
                        room.setSouthRoom(newRoom);
                        newRoom.setNorthRoom(current);
                        break;
                    case NORTH:
                        room.setNorthRoom(newRoom);
                        newRoom.setSouthRoom(current);
                        break;
                    default:
                        return false;
                }
                //setupEnemy(newRoom);
                rooms.add(newRoom);
                return true;
            } else {
                System.out.println("Room not found");
            }

        } else {
            System.out.println("Setup game first");
        }

        return false;
    }

    /**
     * add Enemy To a Room randomly
     */
    private void addEnemyToRoom() {
        Random rand = new Random();
        Room room;
        //get random room
        for (Combatant en : enemies) {
            do {
                room = rooms.get(rand.nextInt(rooms.size()));
            } while (traverse("Entrance").equals(room) || room.hasEnemy());

            System.out.println("Added enemy in +o " + room.getName());
            room.addEnemy(en);
        }

    }


    /**
     * find rooms
     *
     * @return Room found null if not found
     */
    private Room traverse(String name) {
        //check if the size of rooms is more than one
        if (rooms.size() > 0) {
            // for each room
            for (Room room : rooms) {
                // check if we find the room
                if (room.getName() == name) {
                    return room;
                } else {
                    // check all the sides of the room
                    for (Room r : room.getAllSides()) {
                        if (room.getName() == name) {
                            return room;
                        }
                    }

                }

            }
        }
        return null;
    }

    /**
     * The enum Directions.
     */
    protected enum Directions {
        EAST, WEST, NORTH, SOUTH
    }


}
