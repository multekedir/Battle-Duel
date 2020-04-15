package com.revature.entities.rooms;


import com.revature.entities.Combatant;

import java.util.*;

/**
 * The type Room.
 */
public class Room {

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        System.out.println("You are at the " + this.getName());
        Set<Directions> keys = this.getAllSidesMap().keySet();
        for (Directions k : keys) {
            System.out.println("In the " + k + " -> " + this.getAllSidesMap().get(k));

        }
//        String out = "You are at the " + this.getName() + " to your north is " + this.getNorthRoom() +
//                " to your south is " + this.getSouthRoom() + " to your west is " + this.getWestRoom() +
//                " to your east is " + this.getEastRoom();
//        System.out.println(out);
        return "out";
    }

    private Combatant enemy;

    private String name;
    private Room southRoom;
    private Room northRoom;
    private Room eastRoom;
    private Room westRoom;


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

    public Map<Directions, Room> getAllSidesMap() {
        Map<Directions, Room> hm = new HashMap<Directions, Room>();
        if (this.westRoom != null) hm.put(Directions.WEST, this.westRoom);
        if (this.eastRoom != null) hm.put(Directions.EAST, this.eastRoom);
        if (this.southRoom != null) hm.put(Directions.SOUTH, this.southRoom);
        if (this.northRoom != null) hm.put(Directions.NORTH, this.northRoom);
        return hm;
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

    public List<Room> getAllSides() {
        List<Room> rooms = new ArrayList<Room>();
        if (this.westRoom != null) rooms.add(this.westRoom);
        if (this.eastRoom != null) rooms.add(this.eastRoom);
        if (this.southRoom != null) rooms.add(this.southRoom);
        if (this.northRoom != null) rooms.add(this.northRoom);
        return rooms;
    }

    public boolean hasEnemy() {
        return enemy != null;
    }

    public boolean addEnemy(Combatant enemy) {
        this.enemy = enemy;
        return this.enemy == null;
    }

    public Combatant getEnemy() {
        return this.enemy;
    }

    public enum Directions {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }


    @Override
    public String toString() {
        return name;
    }



}

