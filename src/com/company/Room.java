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
    //private Items item;
    private ArrayList<Item> roomItems;

    public Room (String name,String description){
        this.name=name;
        this.description=description;
        this.roomBehavior = 1;
        roomItems = new ArrayList<>();


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

    public void setEast(Room east){
        this.east=east;
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

    public void setRoomBehavior(int roomBehavior){
        this.roomBehavior = roomBehavior;
    }

    public int getRoomBehavior(){
        return roomBehavior;
    }


    public void addRoomItem(Item item){

        roomItems.add(item);

    }

    public void removeRoomItem(Item item){
        roomItems.remove(item);
    }

}

