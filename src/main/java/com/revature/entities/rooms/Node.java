package com.revature.entities.rooms;

/**
 * The type Node.
 */
public class Node {
    private Node west;
    private Node east;
    private Node north;
    private Node south;
    private String name;

    /**
     * Instantiates a new Node.
     *
     * @param west  Node on the west
     * @param east  Node on the east
     * @param north Node on the north
     * @param south Node on the south
     * @param name  Node on the name
     */
    public Node(Node west, Node east, Node north, Node south, String name) {
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
        this.name = name;
        System.out.println("Creating room" + name);
    }

    /**
     * Instantiates a new Node.
     * Adjust node are set set to null
     *
     * @param name the name
     */
    public Node(String name) {
        this.name = name;
        this.east = null;
        this.north = null;
        this.south = null;
        this.name = null;
    }

    public Node(String west, String east, String north, String south, String name) {

        this.name = name;
        this.east = new Node(east);
        this.north = new Node(north);
        this.south = new Node(south);
        this.west = new Node(west);
    }

    /**
     * Gets west node.
     *
     * @return the Node
     */
    public Node getWest() {
        return west;
    }

    /**
     * Sets west node.
     *
     * @param west Node on the west
     */
    public void setWest(Node west) {
        this.west = west;
    }

    /**
     * Gets east node
     *
     * @return the Node
     */
    public Node getEast() {
        return east;
    }

    /**
     * Sets east node.
     *
     * @param east Node on the east
     */
    public void setEast(Node east) {
        this.east = east;
    }

    /**
     * Gets north node.
     *
     * @return Node
     */
    public Node getNorth() {
        return north;
    }

    /**
     * Sets north node.
     *
     * @param north Node on the north
     */
    public void setNorth(Node north) {
        this.north = north;
    }

    /**
     * Gets south node.
     *
     * @return Node
     */
    public Node getSouth() {
        return south;
    }

    /**
     * Sets north south.
     *
     * @param south Node on the south
     */
    public void setSouth(Node south) {
        this.south = south;
    }

    /**
     * Gets name of the node.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name of the Node
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
