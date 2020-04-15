package com.revature.controller;

import com.revature.entities.rooms.Room;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Controller.
 */
public class Controller extends FightController {
    private static Room current;
    private static Room previous;
    private static List<Room> rooms;
    private boolean isSetup = false;

    public static void printDirections() {
        for (Directions d : Directions.values()) {
            System.out.println(" -> " + d);
        }
    }

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

    private static void changePrevious(Room room) {
        previous = room;
    }

    private static void changeCurrent(Room room) {
        current = room;
        if (room.hasEnemy()) fight(room.getEnemy());


    }

    public static void goBack() {
        System.out.println("Going back");
        current = previous;
        current.getDescription();
    }

    public void setup(String heroName) {
        rooms = new ArrayList<Room>();
        current = new Room("Entrance");
        rooms.add(current);
        isSetup = true;

        // setup rooms
        creatRoom("Entrance", "Store", Directions.EAST);
        creatRoom("Entrance", "Road", Directions.NORTH);
        creatRoom("Entrance", "Stable", Directions.WEST);

        //show where I am
        current.getDescription();
        createHero(heroName);
        createEnemy();

    }

    public boolean creatRoom(String oldRoom, String name, Directions direction) {
        System.out.println();
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

    private void setupEnemy(Room room) {
        room.addEnemy(bossEnemy);
    }

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
            return null;
        }
        return null;
    }

    public enum Directions {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }


}
