package com.company;

public class Player {

    private Rooms currentRoom;



    public void setNewRoom(Rooms room){
        this.currentRoom = room;
    }

    public Rooms getCurrentRoom() {
        return currentRoom;
    }
}
