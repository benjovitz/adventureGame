package com.company;

public class Map {

    Rooms starterRoom;

    public void createRooms() {

        Rooms room1 = new Rooms("Rum1 ", "Det her er rum 1");
        Rooms room2 = new Rooms("Rum2 ", "Det her er rum 2");
        Rooms room3 = new Rooms("Rum3 ", "Det her er rum 3");
        Rooms room4 = new Rooms("Rum4 ", "Det her er rum 4");
        Rooms room5 = new Rooms("Rum5 ", "Det her er rum 5");
        Rooms room6 = new Rooms("Rum6 ", "Det her er rum 6");
        Rooms room7 = new Rooms("Rum7 ", "Det her er rum 7");
        Rooms room8 = new Rooms("Rum8 ", "Det her er rum 8");
        Rooms room9 = new Rooms("Rum9 ", "Det her er rum 9");
        //Rooms currentRoom;
        //Rooms currentRoom = room1;




        //room 1 moves
        //room1.setWest(room1);
        //room1.setNorth(room1);


        room1.setEast(room2);
        room1.setSouth(room4);

        //room 2 moves
        //room2.setNorth(room2);
        //room2.setSouth(room2);
        room2.setWest(room1);
        room2.setEast(room3);

        //room 3 moves
        //room3.setNorth(room3);
        //room3.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);

        //room 4 moves
        //room4.setWest(room4);
        // room4.setEast(room4);
        room4.setNorth(room1);
        room4.setSouth(room7);

        //room 5 moves
        //room5.setEast(room5);
        //room5.setNorth(room5);
        //room5.setWest(room5);
        room5.setSouth(room8);

        //room 6 moves
        //room6.setEast(room6);
        //room6.setWest(room6);
        room6.setNorth(room3);
        room6.setSouth(room9);

        //room 7 moves
        //room7.setSouth(room7);
        //room7.setWest(room7);
        room7.setNorth(room4);
        room7.setEast(room8);

        //room 8 moves
        //room8.setSouth(room8);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        //room 9 moves
        //room9.setEast(room9);
        //room9.setSouth(room9);
        room9.setNorth(room6);
        room9.setWest(room8);

        starterRoom = room1;
    }

    public Rooms getStarterRoom() {
        return starterRoom;
    }
}
