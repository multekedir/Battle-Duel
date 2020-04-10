package com.revature.controller;

import com.revature.entities.rooms.Room;

public class Move {


    public Room goNorth(Room current) {
        return current.getNorthNode() != null ? current.getNorthNode() : current.getWallNode();
    }

    public Room goSouth(Room current) {
        return current.getSouthNode() != null ? current.getSouthNode() : current.getWallNode();
    }

    public Room goEast(Room current) {
        return current.getEastNode() != null ? current.getEastNode() : current.getWallNode();
    }

    public Room goWest(Room current) {
        return current.getWestNode() != null ? current.getWestNode() : current.getWallNode();
    }

}
