package com.company;

public class Item {
   private String name;
   private int itemBehavior;
   private int equipped;

    public Item(String name, int itemBehavior, int equipped){
        this.name = name;
        this.itemBehavior=itemBehavior;
        this.equipped = equipped;

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

    public void setEquipped(){
        this.equipped = 1;
    }
    public void unEquipped(){
        this.equipped = 0;
    }


    public int getEquippedStatus(){
        return equipped;
    }

}
