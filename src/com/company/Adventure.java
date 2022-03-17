package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.mainMenu();
    }
    public void mainMenu() {
        String filePath ="magic lute.wav";
        Map map = new Map();
        map.createRooms();
        Music music1 = new Music();
        music1.playMusic(filePath);
        Player player1 = new Player();
        player1.setNewRoom(map.getStarterRoom());

        //intro
        System.out.printf("You wake up drowzy and confused. The room your standing in is dimly lit room,\na fireplace is crackling and what appears to a magical lute is playing by itself in the corner");
        Scanner keyboard = new Scanner(System.in);

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
                    } else System.out.println("you cant go that way");
                    break;
                case "south","go south","s":
                    if (player1.getCurrentRoom().getSouth() != null) {
                        player1.playerPos = player1.getCurrentRoom().getSouth();
                        System.out.println("going south");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else System.out.println("you cant go that way");
                    break;
                case "west","go west","w":
                    if (player1.getCurrentRoom().getWest() != null) {
                        player1.playerPos = player1.getCurrentRoom().getWest();
                        System.out.println("going west");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else System.out.println("you cant go that way");
                    break;
                case "east","go east","e":
                    if (player1.getCurrentRoom().getEast() != null) {
                        player1.playerPos = player1.getCurrentRoom().getEast();
                        System.out.println("going east");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else System.out.println("you cant go that way");
                    break;

                case "look","l":
                    System.out.println(map.starterRoom.getDescription());
                    break;
                case "help","h":
                    System.out.print("this is the help transscript, you can go north, south, east or west." +
                            " Enter either: " +
                            "south; east; north; west.");
                    System.out.println("  to look around type: look");
                    break;
                case "exit":
                    System.out.println("exit game");
                    //System.out.println(currentRoom.getName());
                    stillRunning = false;

                    break;

            }

        }

    }
}

