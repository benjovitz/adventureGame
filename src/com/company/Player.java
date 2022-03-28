package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private Room playerPos;
    private ArrayList<Item> backpack;
    private int health;
    private int cheeseBehavior = 5;
    private int mushroomBehavior = -5;


    public Player (){
        backpack= new ArrayList<>();
    }

    public void setPlayerPos(Room playerPos){
        this.playerPos = playerPos;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
       Item roomItem = playerPos.findItemInRoom(itemName);
       if(roomItem!=null) {
           playerPos.deleteItem(roomItem);
           backpack.add(roomItem);
       }else {
           System.out.println("cant find "+itemName);
       }
    }
    public void showBackpack(){
    System.out.println(backpack);
}
    public Item findItemInBackpack(String itemName) {
        for (int i = 0; i <backpack.size() ; i++) {
            Item tmp = backpack.get(i);
            if (tmp.getItemName().equals(itemName)) {
                return tmp;
            }
        }

        return null;
    }


    public void deleteItem(Item item){
        backpack.remove(item);
    }

    public void dropItem(String itemName) {
        if (findItemInBackpack(itemName)!=null) {
            Item playerItem = findItemInBackpack(itemName);
            deleteItem(playerItem);
            getCurrentRoom().dropItem(playerItem);
        }else {
            System.out.println("cant find "+itemName);
        }

    }

    public void eatFood(String food){
         if (findItemInBackpack(food) instanceof Food) {
            Item playerItem = findItemInBackpack(food);
                deleteItem(playerItem);
                checkFood(playerItem);
        }else {
            System.out.println("cant find "+food);
        }
    }

    public void checkFood(Item food){
        setHealth(getHealth()+food.getItemBehavior());
    }

    public void equipWeapon(String weapon){
        if (findItemInBackpack(weapon) instanceof Weapon) {
            Item playerItem = findItemInBackpack(weapon);
            setWeaponBehavior(playerItem);

        }else {
            System.out.println("cant find "+weapon);
        }
    }

    public void setWeaponBehavior(Item weapon){
        weapon.setEquipped();
        System.out.println(weapon +" is now equipped");
        equippedStatus(weapon);
    }

    public void equippedStatus(Item weapon){
        System.out.println(weapon.getEquippedStatus());
    }

}


