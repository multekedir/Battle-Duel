package com.revature.entities.rooms;

public interface RoomNode {

    String getNodeName();

    void setNodeName(String name);

    RoomNode getNorthNode();

    void setNorthNode(Room north);

    RoomNode getSouthNode();

    void setSouthNode(Room south);

    RoomNode getEastNode();

    void setEastNode(Room east);

    RoomNode getWestNode();

    void setWestNode(Room west);

    RoomNode getWallNode();
}
