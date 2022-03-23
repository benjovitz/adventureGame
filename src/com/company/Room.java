package com.company;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private int roomBehavior;
    private ArrayList<Item> roomItems;

    private Player currentPlayer;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.roomBehavior = 1;
        roomItems = new ArrayList<>();



    }

    //test
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setEast(Room east) {
        this.east = east;
    }


    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomBehavior(int roomBehavior) {
        this.roomBehavior = roomBehavior;
    }

    public int getRoomBehavior() {
        return roomBehavior;
    }


    public void addRoomItem(Item item) {

        roomItems.add(item);

    }


    public Item deleteItem(String itemName) {
        for (int i = 0; i < roomItems.size(); i++) {
            Item tmp = roomItems.get(i);
            if (tmp.getItemName().equals(itemName)) {
                roomItems.remove(tmp);
                return tmp;
            }
        }

        return null;
    }

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    //test
    public void dropItem (String itemName){
        Item playerItem = currentPlayer.findItemInBackpack(itemName);
        roomItems.add(playerItem);
    }
}

