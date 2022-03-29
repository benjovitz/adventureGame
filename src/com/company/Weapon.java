package com.company;

public abstract class Weapon extends Item {
    private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public abstract void ammoChecker();

    public abstract void setDamage();
    public abstract int getDamage();

}
