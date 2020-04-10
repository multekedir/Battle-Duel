package com.revature.entities.rooms;

public class Room implements RoomNode {
    private Room west;
    private Room east;
    private Room north;
    private Room south;
    private Room wall;
    private String name;

    public Room(Room west, Room east, Room north, Room south, String name) {
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
        this.name = name;
    }

    public Room(String name) {
        this.name = name;
    }

    public String getNodeName() {
        return this.name;
    }

    public void setNodeName(String name) {
        this.name = name;
    }

    public Room getNorthNode() {
        return this.north;
    }

    public void setNorthNode(Room north) {
        this.north = north;
    }

    public Room getSouthNode() {
        return this.south;
    }

    public void setSouthNode(Room south) {
        this.south = south;
    }

    public Room getEastNode() {
        return this.east;
    }

    public void setEastNode(Room east) {
        this.east = east;
    }

    public Room getWestNode() {
        return this.west;
    }

    public void setWestNode(Room west) {
        this.west = west;
    }

    public Room getWallNode() {
        return this.wall;
    }


}
