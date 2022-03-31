package com.company;

public class Map {

    private Room starterRoom;

    public void createWorld() {

        Room room1 = new Room("Rum1 ", "Det her er rum 1");
        Room room2 = new Room("Rum2 ", "Det her er rum 2");
        Room room3 = new Room("Rum3 ", "Det her er rum 3");
        Room room4 = new Room("Rum4 ", "Det her er rum 4");
        Room room5 = new Room("Rum5 ", "Det her er rum 5");
        Room room6 = new Room("Rum6 ", "Det her er rum 6");
        Room room7 = new Room("Rum7 ", "Det her er rum 7");
        Room room8 = new Room("Rum8 ", "Det her er rum 8");
        Room room9 = new Room("Rum9 ", "Det her er rum 9");

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);

        starterRoom = room1;
        //items bliver oprettet
        Item item1 = new Item("coin");
        Item item2 = new Item("torch");

        //food bliver oprettet
        Food food1 = new Food("cheese",3);
        Food food2 = new Food("mushroom",-3);

        //weapons bliver oprettet
        MeleeWeapon meleeWeapon1 = new MeleeWeapon("axe",3);
        RangedWeapon rangedWeapon1 = new RangedWeapon("bow",2,10);
        MeleeWeapon meleeWeapon2 = new MeleeWeapon("black oozing branch",1);


        Enemy troll1 = new Enemy("lars", 8,meleeWeapon2);

        room2.addEnemies(troll1);

        room1.addRoomItem(item1);
        room2.addRoomItem(item2);
        room1.addRoomItem(food1);
        room2.addRoomItem(food2);
        room1.addRoomItem(meleeWeapon1);
        room1.addRoomItem(rangedWeapon1);
    }



    public Room getStarterRoom() {
        return starterRoom;
    }
}