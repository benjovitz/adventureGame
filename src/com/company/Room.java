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
    private ArrayList<Enemy>enemies;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.roomBehavior = 1;
        roomItems = new ArrayList<>();
        enemies = new ArrayList<>();



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


    public Item findItemInRoom(String itemName) {
        for (int i = 0; i < roomItems.size(); i++) {
            Item tmp = roomItems.get(i);
            if (tmp.getItemName().equals(itemName)) {
                return tmp;
            }
        }

        return null;
    }

    public void deleteItem(Item item){
        roomItems.remove(item);
    }

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemies(Enemy enemy){
        enemies.add(enemy);
    }

    //test
    public void dropItem (Item playerItem){
        roomItems.add(playerItem);
    }




}

