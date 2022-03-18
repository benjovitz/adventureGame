package com.company;

public class Item {
   private String name;
   Item item;

    public Item(String name){
        this.name = name;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public String getItemName() {
        return name;
    }
    //sdah
}
