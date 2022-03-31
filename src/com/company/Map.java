package com.company;

public class Map {

    private Room starterRoom;

    public void createWorld() {

        Room room1 = new Room("Subway ", "Subway, sandwiches are spread (pun intended) all over the floor\nsee? there is a single sandwich still in its wrapper\nthere is also a plant, might come in useful\n");
        Room room2 = new Room("Jysk ", "Jysk, once a place of dreams and a good nights rest, is now just empty hal-\nWAIT, WHAT WAS THAT NOISE, sounds like a faint groaning\n");
        Room room3 = new Room("Empty hall ", "Nothing here to talk about...\n");
        Room room4 = new Room("Empty hall ", "Nothing here to talk about...\n");
        Room room5 = new Room("TOYS'R'US ", "TOYS'R'US, lucky we still fit in through the little slide for kids, the main doors are closed\nwhat happened to this place? and what is that awful smell?");
        Room room6 = new Room("McDonalds ", "McDonalds, was a place of horror, nothing has changed there, somehow all the food is not expired...\n*giggles* what was that? WHERE DID IT COME FROM?\n");
        Room room7 = new Room("Empty hall ", "Nothing here to talk about...\n");
        Room room8 = new Room("Lagkagehuset ", "Lagkagehuset, Look stranger! a cake. I hope its still good to go. How about you take a bite first?\n");
        Room room9 = new Room("Ikea ", "IKEA, thought it was the swedish flag for a second there, you know what? i have so many things from IKEA, its insane\nmy kidney is from IKEA believe it or not");
        Room room10 = new Room("Empty hall ", "Nothing here to talk about...\n");
        Room room11 = new Room("Bilnka ", "Bilka, never did like this place, its just too big for the likes of me.\nYou know im much more of a Netto kind of fell-\n*RAWR* oh come on");
        Room room12 = new Room("Steffs place ", "Steffs place, you must feel home here with a dirty vest and strong pornography in your glovebox\n looks like there is an uneaten hotdog... i wouldnt eat that...");
        Room room13 = new Room("Empty hall ", "Nothing here to talk about...\n");
        Room room14 = new Room("Empty hall ", "Nothing here to talk about...\n");
        Room room15 = new Room("Fætter BR ", "Fætter BR, my dad used to take me here, now he only has 1 leg...\nI wonder if there is a correlation\n is that a monkey in a vest?");
        Room room16 = new Room("Fitness World ", "Fitness World, what a sweaty place");
        Room room17 = new Room("Leasy Peters Room ", "YO MY MAN, thats the guy that took my sunglasses, he is even wearing them.\nWont lie, he looks kinda swanky in them, they are mine tho...LETS GET HIM STRANGER!!!");

        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(room10);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setWest(room11);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setSouth(room13);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);
        room9.setEast(room14);
        room9.setSouth(room15);

        room10.setEast(room1);
        room10.setSouth(room11);
        room10.setWest(room12);

        room11.setNorth(room10);
        room11.setEast(room4);

        room12.setEast(room10);

        room13.setNorth(room7);

        room14.setWest(room9);
        room14.setSouth(room16);

        room15.setEast(room16);
        room15.setNorth(room9);

        room16.setNorth(room14);
        room16.setWest(room15);
        room16.setEast(room17);

        room17.setWest(room16);

        starterRoom = room1;
        //items bliver oprettet

        //food bliver oprettet
        Food food1 = new Food("sandwich", 10);
        Food food2 = new Food("trash", -5);
        Food food3 = new Food("bleach",-100);
        Food food4 = new Food("meatball",10);
        Food food5 = new Food("cake",20);
        Food food6 = new Food("proteinshake",10);
        Food food7 = new Food("hotdog",10);

        room1.addRoomItem(food1);
        room3.addRoomItem(food2);
        room7.addRoomItem(food3);
        room9.addRoomItem(food4);
        room8.addRoomItem(food5);
        room16.addRoomItem(food6);
        room12.addRoomItem(food7);


        //weapons bliver oprettet
        RangedWeapon rangedWeapon1 = new RangedWeapon("slingshot", 8, 7);
        RangedWeapon rangedWeapon2 = new RangedWeapon("lego", 40, 2);

        MeleeWeapon meleeWeapon1 = new MeleeWeapon("plant", 6);
        MeleeWeapon meleeWeapon2 = new MeleeWeapon("pillow", 10);
        MeleeWeapon meleeWeapon3 = new MeleeWeapon("happy meal", 15);
        MeleeWeapon meleeWeapon4 = new MeleeWeapon("claws", 18);
        MeleeWeapon meleeWeapon5 = new MeleeWeapon("whistle", 20);
        MeleeWeapon meleeWeapon6 = new MeleeWeapon("phone", 64);

        Enemy enemy1 = new Enemy("lars", "Lars Larsen is now a zombie and roams the empty Jysk stores. He attacks by strangling you with a deadly soft pillow, try not to fall asleep", 20, meleeWeapon2);
        Enemy enemy2 = new Enemy("ronald", "Ronald McDonald is trying to give you type 2 diabetes with his happy meal, WATCH OUT", 30, meleeWeapon3);
        Enemy enemy3 = new Enemy("billie", "Some say the Bilka wolf Billie is Fenrir just waiting for Ragnarock to happen, he has sharp claws!", 40, meleeWeapon4);
        Enemy enemy4 = new Enemy("br", "Fætter BR has lured children into his store for years, raising an army of child soldiers. Careful, he has a whistle that calls a child to attack you", 45, meleeWeapon5);
        Enemy enemy5 = new Enemy("giraffe", "theres a dead giraffe on the floor, he had 2 legoBricks on him, use them wisely, they hurt to step on", 0, rangedWeapon2);
        Enemy enemy6 = new Enemy("peter", "Leasy Peter is the last boss, 8x8 damage... hit you with that quickloan.Hope you saved your Lego bricks and food.", 60, meleeWeapon6);

        room2.addEnemies(enemy1);
        room6.addEnemies(enemy2);
        room11.addEnemies(enemy3);
        room15.addEnemies(enemy4);
        room5.addEnemies(enemy5);
        room17.addEnemies(enemy6);


        room1.addRoomItem(meleeWeapon1);
        room13.addRoomItem(rangedWeapon1);

    }


    public Room getStarterRoom() {
        return starterRoom;
    }
}