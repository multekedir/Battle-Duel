package com.revature.entities.rooms;

public class Node {
    private Node west;
    private Node east;
    private Node north;
    private Node south;
    private String name;

    public Node(Node west, Node east, Node north, Node south, String name) {
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
        this.east = null;
        this.north = null;
        this.south = null;
        this.name = null;
    }


    public Node getWest() {
        return west;
    }

    public void setWest(Node west) {
        this.west = west;
    }

    public Node getEast() {
        return east;
    }

    public void setEast(Node east) {
        this.east = east;
    }

    public Node getNorth() {
        return north;
    }

    public void setNorth(Node north) {
        this.north = north;
    }

    public Node getSouth() {
        return south;
    }

    public void setSouth(Node south) {
        this.south = south;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
