package com.company;

import java.util.Locale;
import java.util.Scanner;

public class GameEngine {
    private Player player1;
    private Text textObj;
    private Map map;
    private Music music1;
    private Scanner keyboard;


    public GameEngine(){
        textObj = new Text();
        player1 = new Player();
        map = new Map();
        music1 = new Music();
        keyboard = new Scanner(System.in);


    }

    public void mainMenu() {

        map.createRooms();
        //music oprettet, spillet og filepath defineret
        String filePath = "magic lute.wav";
        music1.playMusic(filePath);

        //player oprettet og player pos sat til room1.

        player1.setPlayerPos(map.getStarterRoom());
        map.roomObj.getItemDes();
        //map.roomObj..getItemName();
        textObj.intro();

        boolean stillRunning = true;
        while (stillRunning) {

            String command = keyboard.nextLine().toLowerCase(Locale.ROOT).trim();
            //movement command
            if (command.startsWith("go ")) {
                String direction = command.substring(command.indexOf(" ") + 1);
                playerMovement(direction);

            } else {
                //switch for help commands
                switch (command) {
                    case "look", "l" -> System.out.println(player1.getCurrentRoom().getDescription());
                    case "help", "h" -> textObj.help();
                    case "exit" -> {
                        stillRunning = false;
                        textObj.exit();
                    }

                    default -> textObj.invalidInput();

                }
            }

        }

    }

    //movement directionpicker
    public void playerMovement(String direction) {
        switch (direction) {
            case "north", "n" -> {
                textObj.movement(direction);
                moveNorth();
            }
            case "south", "s" -> {
                textObj.movement(direction);
                moveSouth();
            }
            case "west", "w" -> {
                textObj.movement(direction);
                moveWest();
            }
            case "east", "e" -> {
                textObj.movement(direction);
                moveEast();
            }
            default -> textObj.invalidInput();
        }

    }

    //movement mechanic
    public void moveNorth() {
        if (player1.getCurrentRoom().getNorth() != null) {
            player1.setPlayerPos(player1.getCurrentRoom().getNorth());
            roomBehavior();
        } else {
            textObj.invalidRoute();
        }
    }

    //same
    public void moveSouth() {
        if (player1.getCurrentRoom().getSouth() != null) {
            player1.setPlayerPos(player1.getCurrentRoom().getSouth());
            roomBehavior();
        } else {
            textObj.invalidRoute();
        }
    }

    //same
    public void moveWest() {
        if (player1.getCurrentRoom().getWest() != null) {
            player1.setPlayerPos(player1.getCurrentRoom().getWest());
            roomBehavior();
        } else {
            textObj.invalidRoute();
        }

    }

    //same
    public void moveEast() {
        if (player1.getCurrentRoom().getEast() != null) {
            player1.setPlayerPos(player1.getCurrentRoom().getEast());
            roomBehavior();
        } else {
            textObj.invalidRoute();
        }
    }

    //checking if you have been in the room beforehand
    public void roomBehavior() {
        if (player1.getCurrentRoom().getRoomBehavior() == 1) {
            System.out.println(player1.getCurrentRoom().getDescription());
            player1.getCurrentRoom().setRoomBehavior(0);
        }
    }


}



