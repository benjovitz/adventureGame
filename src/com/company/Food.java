package com.company;

public class Food extends Item{
    private int healthGain;

    public Food(String name,int healthgain) {
        super(name);
        this.healthGain=healthgain;
    }

    public int getHealthGain() {
        return healthGain;
    }
}
