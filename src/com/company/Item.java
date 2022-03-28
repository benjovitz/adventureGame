package com.company;

public class Item {
   private String name;
   private int itemBehavior;

    public Item(String name,int itemBehavior){
        this.name = name;
        this.itemBehavior=itemBehavior;
    }
    public String getItemName() {
        return name;
    }
    public String toString(){

        return name;
    }

    public int getItemBehavior() {
        return itemBehavior;
    }
}
