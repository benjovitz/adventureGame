package com.company;

import java.util.Locale;
import java.util.Scanner;

public class GameEngine {
    private final Player player1;
    private final Text textObj;
    private final Map map;
    private final Music music1;
    private final Scanner keyboard;

    //private final Items coin;


    public GameEngine() {
        textObj = new Text();
        player1 = new Player();
        map = new Map();
        music1 = new Music();
        keyboard = new Scanner(System.in);
        map.createWorld();


    }

    public void mainMenu() {
        //music oprettet, spillet og filepath defineret
        String filePath = "magic lute.wav";
        music1.playMusic(filePath);
        //player oprettet og player pos sat til room1.
        player1.setPlayerPos(map.getStarterRoom());
        //map.roomObj.getItemDes();
        //map.roomObj..getItemName();
        textObj.intro();


        boolean stillRunning = true;
        while (stillRunning) {

            String command = keyboard.nextLine().toLowerCase(Locale.ROOT).trim();
            //movement command
            if (command.startsWith("go ")) {
                String direction = command.substring(command.indexOf(" ") + 1);
                playerMovement(direction);
                hasMoved(direction);

            } else if (command.startsWith("take ")||command.startsWith("t ")){
                String item = command.substring(command.indexOf(" ")+1);
                player1.takeItem(item);
            } else {
                //switch for help commands
                switch (command) {
                    case "look", "l" -> {System.out.println(player1.getCurrentRoom().getDescription());
                        System.out.println(player1.getCurrentRoom().getRoomItems());
                    }
                    case "help", "h" -> textObj.help();
                    case "backpack", "b" -> player1.showBackpack();
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
                player1.moveNorth();
            }
            case "south", "s" -> {
                textObj.movement(direction);
                player1.moveSouth();
            }
            case "west", "w" -> {
                textObj.movement(direction);
                player1.moveWest();
            }
            case "east", "e" -> {
                textObj.movement(direction);
                player1.moveEast();
            }
            default -> textObj.invalidInput();
        }

    }

    public void hasMoved(String direction) {
        switch (direction) {
            case "north", "n" -> {
                if (player1.getCurrentRoom().getNorth() == null) {
                    textObj.invalidRoute();
                }
            }
            case "south", "s" -> {
                if (player1.getCurrentRoom().getSouth() == null) {
                    textObj.invalidRoute();
                }
            }
            case "west", "w" -> {
                if (player1.getCurrentRoom().getWest() == null) {
                    textObj.invalidRoute();
                }
            }
            case "east", "e" -> {
                if (player1.getCurrentRoom().getEast() == null) {
                    textObj.invalidRoute();
                }
            }
        }
    }

}




