package com.company;

public class Enemy {
    private String name;
    private int health;
    private Weapon currentWeapon;
    //private Room currentRoom;

    public Enemy(String name, int health, Weapon currentWeapon){
        this.name = name;
        this.health = health;
        this.currentWeapon = currentWeapon;
        //this.currentRoom = currentRoom;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return name;

    }
    public void hit(int damage){
        setHealth(getHealth()-damage);
    }

    public Weapon deathDrop(){
        return currentWeapon;
    }
    public int attack(){
        return currentWeapon.getDamage();
    }


}
