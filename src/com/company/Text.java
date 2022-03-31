package com.company;

public class Text {

    public String intro(){
        return "Hello there stranger, you see that old mall there? My sunglasses got stolen...Some guy just ran up and stole them from me...So rude\nwill you help me find them?\ny or n?";

    }

    public String help(){
        return "this is a help transcript\nlook: look around the room\nbackpack: look in your backpack\nhp:see your current health\ngo+direcntion:go to your wanted direction\nattack+enemy name:to attack an enemy\ntake+item name:to take an item and put in into your backpack\neat+food name:to eat food and gain health\ndrop+item name:to drop an item\nequip+weapon name: to equip a weapon, your hands do no damage:(\nunequip+weapon name: to unequip a weapon, no duo wielding son\nspecs+item name: to get health gain/damage/ammo and name on your item\n";
    }

    public void exit(){
        System.out.println("exit game");
    }

    public String invalidRoute(){
        return "You cant go that way";
    }
    public String invalidInput(){
        return "Invalid input";
    }
    public String movement (String direction){

        return "Going " + direction;
    }
    public void seeHealth(int health){
        System.out.println("you have "+ health + " HP left");
        String heart = "\u2764";
        for (int i = 0; i < health; i++) {
            System.out.print(heart+ " ");
        }
    }
    public String deadEnemy(String enemyName){
        return enemyName+ " died a painfull death :(";
    }
    public String didntHelp(){
        return "Oh... okay... guess you got better things to do...";
    }
    public String didHelp(){
        return "Oh thank you so much stranger, lets go then,queue the music baby";
    }
    public void gameTextPrinter(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(20);
        }
        System.out.println();
    }
}

