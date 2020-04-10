package com.revature.entities.rooms;


import com.revature.entities.Attack;

import java.util.Arrays;
import java.util.List;

public class Room extends Node {


    public Room(Room west, Room east, Room north, Room south, String name) {
        super(west, east, north, south, name);
    }


    public String getDescription() {
        String out = "You are in " + this.getName() + " to your north is " + this.getNorth() +
                " to your south is " + this.getSouth() + " to your west is " + this.getWest() +
                " to your east is " + this.getEast();

        return out;
    }


}

