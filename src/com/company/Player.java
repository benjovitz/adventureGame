package com.company;

public class Player {

    Rooms playerPos;




    public void setNewRoom(Rooms playerPos){
        this.playerPos = playerPos;
    }

    public Rooms getCurrentRoom() {
        return playerPos;
    }
}
