package com.revature.controller;

import com.revature.entities.rooms.Room;

public class Controller {


    public Room goNorth(Room current) {
        return (Room) current.getNorth();
    }

    public Room goSouth(Room current) {
        return (Room) current.getSouth();
    }

    public Room goEast(Room current) {
        return (Room) current.getEast();
    }

    public Room goWest(Room current) {
        return (Room) current.getWest();
    }

}
