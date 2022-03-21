package com.company;

import java.util.ArrayList;

public class Player {

    private Room playerPos;
    private ArrayList<Item> backpack;

    public Player (){
        backpack= new ArrayList<>();
    }

    public void setPlayerPos(Room playerPos){
        this.playerPos = playerPos;
    }


    public Room getCurrentRoom() {
        return playerPos;
    }


    public void moveNorth() {
        if (playerPos.getNorth() != null) {
            setPlayerPos(playerPos.getNorth());
            roomBehavior();
        }
    }

    //same
    public void moveSouth() {
        if (playerPos.getSouth() != null) {
            setPlayerPos(playerPos.getSouth());
            roomBehavior();
        }
    }

    //same
    public void moveWest() {
        if (playerPos.getWest() != null) {
            setPlayerPos(playerPos.getWest());
            roomBehavior();
        }

    }

    //same
    public void moveEast() {
        if (playerPos.getEast() != null) {
            setPlayerPos(playerPos.getEast());
            roomBehavior();
        }
    }

    public void roomBehavior() {
        if (playerPos.getRoomBehavior() == 1) {
            System.out.println(playerPos.getDescription());
            playerPos.setRoomBehavior(0);
        }
    }
    public void takeItem (String itemName){
       Item roomItem = playerPos.deleteItem(itemName);
       backpack.add(roomItem);
    }
    public void showBackpack(){
    System.out.println(backpack);
}


}
