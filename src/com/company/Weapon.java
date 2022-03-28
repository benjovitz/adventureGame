package com.company;

public abstract class Weapon extends Item {

    //private int equipped;

    public Weapon(String name,int damage,int equipped,int ammo){
        super(name,damage, equipped,ammo);
    }
}
