package com.revature.controller;

import com.revature.entities.rooms.Room;

public class Controller {

    public Room creatRoom(String[] names) {
        if (names.length == 5) {
            return new Room(names[0], names[1], names[2], names[3], names[4]);
        } else {
            return null;
        }
//        return true;
    }

    public Room goNorth(Room current) {
        return current.getNorthRoom();
    }

    public Room goSouth(Room current) {
        return current.getSouthRoom();
    }

    public Room goEast(Room current) {
        return current.getEastRoom();
    }

    public Room goWest(Room current) {
        return current.getWestRoom();
    }

}
