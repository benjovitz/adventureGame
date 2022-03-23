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
        //music
        String filePath = "magic lute.wav";
        music1.playMusic(filePath);
        //player placed in room 1
        player1.setPlayerPos(map.getStarterRoom());
        //intro text
        textObj.intro();
        //


    }

    public void mainMenu() {
        boolean stillRunning = true;
        while (stillRunning) {

            String s = keyboard.nextLine().toLowerCase(Locale.ROOT).trim();
            //splitting commands up
            String[] command = s.split(" ");
            //switch for commands
            switch (command[0]) {
                case "go", "g" -> {
                    textObj.movement(command[1]);
                    invalidRouteChecker(command[1]);
                    playerMovement(command[1]);
                }
                case "take", "t" -> {
                    takeItem(command[1]);
                }
                case "look", "l" -> {
                    System.out.println(player1.getCurrentRoom().getDescription());
                    System.out.println(player1.getCurrentRoom().getRoomItems());
                }
                case "help", "h" -> textObj.help();
                case "backpack", "b" -> player1.showBackpack();
                case "drop", "d" -> {
                    //test
                    dropItem(command[1]);
                }
                case "health","hp" -> textObj.seeHealth(player1.getHealth());
                //case "use","u" -> player1.useItem
                case "exit" -> {
                    stillRunning = false;
                    textObj.exit();
                }

                default -> textObj.invalidInput();

            }
        }

    }


    //movement directionpicker
    public void playerMovement(String direction) {
        switch (direction) {
            case "north", "n" -> {
                player1.moveNorth();
            }
            case "south", "s" -> {
                player1.moveSouth();
            }
            case "west", "w" -> {
                player1.moveWest();
            }
            case "east", "e" -> {
                player1.moveEast();
            }
            default -> textObj.invalidInput();
        }

    }

    public void invalidRouteChecker(String direction) {
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

    public void dropItem(String itemName) {
            player1.getCurrentRoom().setCurrentPlayer(player1);
            player1.getCurrentRoom().dropItem(itemName);


    }

    public void takeItem(String itemName) {
            player1.takeItem(itemName);

    }
}





