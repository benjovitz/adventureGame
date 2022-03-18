package com.company;

public class Rooms {
    private String name;
    private String description;
    private Rooms north;
    private Rooms south;
    private Rooms east;
    private Rooms west;
    private int roomBehavior;
    Items item;



    public Rooms (String name,String description){
        this.name=name;
        this.description=description;
        this.roomBehavior = 1;

    }

    public void setNorth(Rooms north) {
        this.north = north;
    }

    public void setSouth(Rooms south) {
        this.south = south;
    }

    public void setWest(Rooms west) {
        this.west = west;
    }

    public void setEast(Rooms east){
        this.east=east;
    }


    public Rooms getNorth() {
        return north;
    }

    public Rooms getSouth() {
        return south;
    }

    public Rooms getEast() {
        return east;
    }

    public Rooms getWest() {
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

    public void setItem(Items item){
        this.item
    }

}
