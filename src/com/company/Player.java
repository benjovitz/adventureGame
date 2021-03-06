package com.company;

import java.util.ArrayList;

public class Player {

    private Room playerPos;
    private ArrayList<Item> backpack;
    private int health;
    private Weapon currentWeapon;


    public Player() {
        backpack = new ArrayList<>();
    }

    public void setPlayerPos(Room playerPos) {
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
            System.out.println(playerPos.getRoomItems());
            System.out.println(playerPos.getEnemies());
            playerPos.setRoomBehavior(0);
        }
    }

    public void takeItem(String itemName) {
        Item roomItem = playerPos.findItemInRoom(itemName);
        if (roomItem != null) {
            playerPos.deleteItem(roomItem);
            backpack.add(roomItem);
        } else {
            System.out.println("cant find " + itemName);
        }
    }

    public void showBackpack() {
        System.out.println(backpack);
    }

    public Item findItemInBackpack(String itemName) {
        for (int i = 0; i < backpack.size(); i++) {
            Item tmp = backpack.get(i);
            if (tmp.getItemName().equals(itemName)) {
                return tmp;
            }
        }
        return null;
    }


    public void deleteItem(Item item) {
        backpack.remove(item);
    }

    public void dropItem(String itemName) {
        if (findItemInBackpack(itemName) != null) {
            Item playerItem = findItemInBackpack(itemName);
            deleteItem(playerItem);
            getCurrentRoom().dropItem(playerItem);
        } else {
            System.out.println("cant find " + itemName);
        }

    }

    public void eatFood(String foodName) {
        if (findItemInBackpack(foodName) instanceof Food) {
            Food foodItem = (Food)findItemInBackpack(foodName);
            deleteItem(foodItem);
            gainHealth(foodItem);
        } else {
            System.out.println("cant find " + foodName);
        }
    }

    public void gainHealth(Food food) {
        if(health<=100){
            setHealth(getHealth() + food.getHealthGain());
        }
    }

    public void equipWeapon(String weaponName) {
        if (findItemInBackpack(weaponName) instanceof Weapon) {
            currentWeapon = (Weapon)findItemInBackpack(weaponName);
        } else {
            System.out.println("cant find " + weaponName);
        }
    }

    public void unEquipWeapon(String weaponName) {
        if (findItemInBackpack(weaponName) instanceof Weapon) {
            currentWeapon = (Weapon)findItemInBackpack(weaponName);
            unEquip(currentWeapon);
        } else {
            System.out.println("cant find " + weaponName);
        }
    }


    public void unEquip(Item weapon) {
        if (currentWeapon!=null) {
            currentWeapon=null;
            System.out.println(weapon + " is now unequipped");
        } else System.out.println("weapon is not equipped");
    }


    public int attackMove() {
        if (currentWeapon != null) {
            return currentWeapon.getWeaponStatus();

        }else {
            System.out.println("You have no weapon equipped");
            return 0;
        }
    }

    public void hit(int dmg){
        setHealth(getHealth()-dmg);
    }


}


