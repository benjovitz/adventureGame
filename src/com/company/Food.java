package com.company;

public class Food extends Item{
    private int healthgain;

    public Food(String name,int healthgain) {
        super(name);
        this.healthgain=healthgain;
    }

    public int getHealthgain() {
        return healthgain;
    }
}
