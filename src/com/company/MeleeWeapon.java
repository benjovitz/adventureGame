package com.company;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void ammoChecker() {
    }

    @Override
    public void setDamage() {

    }

    @Override
    public int getDamage() {
        return 0;
    }
}
