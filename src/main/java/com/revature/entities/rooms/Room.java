package com.revature.entities.rooms;


import com.revature.entities.Attack;

import java.util.Arrays;
import java.util.List;

/**
 * The type Room.
 */
public class Room extends Node {


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
        super(new Node(west), new Node(east), new Node(north), new Node(south), name);
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        String out = "You are in " + this.getName() + " to your north is " + this.getNorth() +
                " to your south is " + this.getSouth() + " to your west is " + this.getWest() +
                " to your east is " + this.getEast();

        return out;
    }


}

