package com.revature.entities.rooms;


import com.revature.entities.Attack;

import java.util.Arrays;
import java.util.List;

/**
 * The type Room.
 */
public class Room {


    private Room southRoom;
    private Room northRoom;
    private Room eastRoom;
    private Room westRoom;
    private String name;

    /**
     * Instantiates a new Room.
     *
     * @param west  the name of a room on the west
     * @param east  the name of a room on the east
     * @param north the name of a room on the north
     * @param south the name of a room on the south
     * @param name  the name of a room on the name
     */
    public Room(String west, String east, String north, String south, String name) {
        this.name = name;
        this.westRoom = new Room(west);
        this.eastRoom = new Room(east);
        this.northRoom = new Room(north);
        this.southRoom = new Room(south);


    }

    public Room(String name) {
        this.name = name;
        this.westRoom = null;
        this.eastRoom = null;
        this.northRoom = null;
        this.southRoom = null;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        String out = "You are at " + this.getName() + " to your north is " + this.getNorthRoom() +
                " to your south is " + this.getSouthRoom() + " to your west is " + this.getWestRoom() +
                " to your east is " + this.getEastRoom();

        return out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
    }

    @Override
    public String toString() {
        return name;
    }


}

