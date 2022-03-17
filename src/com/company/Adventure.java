package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.mainMenu();
    }
    public void mainMenu() {
        //scanner oprettet
        Scanner keyboard = new Scanner(System.in);
        //map opretttet og createt
        Map map = new Map();
        map.createRooms();
        //music oprettet, spillet og filepath defineret
        String filePath ="magic lute.wav";
        Music music1 = new Music();
        music1.playMusic(filePath);
        //player oprettet og player pos sat til room1.
        Player player1 = new Player();
        player1.setNewRoom(map.getStarterRoom());
        Text textObj = new Text();
        textObj.intro();



        boolean stillRunning = true;
        while (stillRunning) {

            String command = keyboard.nextLine();
            String switchCommand=command.substring(0,command.length()).toLowerCase(Locale.ROOT);


            switch (switchCommand) {
                case "north","go north","n":

                    if (player1.getCurrentRoom().getNorth() != null) {
                        player1.playerPos = player1.getCurrentRoom().getNorth();
                        System.out.println("going north");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else textObj.invalidRoute();
                    break;
                case "south","go south","s":
                    if (player1.getCurrentRoom().getSouth() != null) {
                        player1.playerPos = player1.getCurrentRoom().getSouth();
                        System.out.println("going south");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else textObj.invalidRoute();
                    break;
                case "west","go west","w":
                    if (player1.getCurrentRoom().getWest() != null) {
                        player1.playerPos = player1.getCurrentRoom().getWest();
                        System.out.println("going west");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else textObj.invalidRoute();;
                    break;
                case "east","go east","e":
                    if (player1.getCurrentRoom().getEast() != null) {
                        player1.playerPos = player1.getCurrentRoom().getEast();
                        System.out.println("going east");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else textObj.invalidRoute();
                    break;

                case "look","l":
                    System.out.println(map.starterRoom.getDescription());
                    break;
                case "help","h":
                   textObj.help();
                    break;
                case "exit":
                    textObj.exit();
                    stillRunning = false;
                    break;

            }

        }

    }
}

