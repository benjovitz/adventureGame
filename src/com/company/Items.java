package com.company;

public class Items {
   private String name;
   Items item;

    public Items(String name){
        this.name = name;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Items getItem() {
        return item;
    }

    public String getItemName() {
        return name;
    }
}
