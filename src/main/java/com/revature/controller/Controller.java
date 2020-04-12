package com.revature.controller;

import com.revature.entities.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Room current = null;
    Room previous = null;
    List<Room> rooms = new ArrayList<Room>();

    Room newRoom;

    public boolean creatRoom(String[] names) {
        if (names.length == 5) {
            newRoom = new Room(names[0], names[1], names[2], names[3], names[4]);
            if (current == null) current = newRoom;
            current.getDescription();
            rooms.add(newRoom);
        } else {
            return false;
        }
        return true;
    }

    public void goNorth() {
        System.out.println("Going North");
        this.previous = this.current;
        this.current = current != null ? current.getNorthRoom() : current;
        current.getDescription();
    }

    public void goSouth() {
        System.out.println("Going South");
        this.previous = this.current;
        this.current = current != null ? this.current.getSouthRoom() : current;
        current.getDescription();
    }

    public void goEast() {
        System.out.println("Going East");
        this.previous = this.current;
        this.current = current != null ? this.current.getEastRoom() : current;
        current.getDescription();
    }

    public void goWest() {
        System.out.println("Going West");
        this.previous = this.current;
        this.current = current != null ? this.current.getWestRoom() : current;
        current.getDescription();
    }

    public void goBack() {
        System.out.println("Going back");
        this.current = this.previous;
        this.current.getDescription();
    }


}
