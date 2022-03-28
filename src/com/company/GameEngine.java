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
        player1.setHealth(20);
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
            menuPicker(command);
            //switch for commands
/*            switch (command[0]) {
                case "go", "g" -> {
                    textObj.movement(command[1]);
                    invalidRouteChecker(command[1]);
                    playerMovement(command[1]);
                }
                case "take", "t" -> player1.takeItem(command[1]);
                case "eat" -> player1.eatFood(command[1]);
                case "look", "l" -> {
                    System.out.println(player1.getCurrentRoom().getDescription());
                    System.out.println(player1.getCurrentRoom().getRoomItems());
                }
                case "help", "h" -> textObj.help();
                case "backpack", "b" -> player1.showBackpack();
                case "drop", "d" -> player1.dropItem(command[1]);
                case "health", "hp" -> textObj.seeHealth(player1.getHealth());
                case "exit" -> {
                    stillRunning = false;
                    textObj.exit();
                }

                default -> textObj.invalidInput();

            }*/
        }

    }

    public void menuPicker(String[] command) {
        if(command.length==1){
            oneWordSwitch(command);
        } else {
            twoWordSwitch(command);
        }

    }

    public void oneWordSwitch(String[] command) {
        switch (command[0]){
            case "look", "l" -> {
                System.out.println(player1.getCurrentRoom().getDescription());
                System.out.println(player1.getCurrentRoom().getRoomItems());
            }
            case "help", "h" -> textObj.help();
            case "backpack", "b" -> player1.showBackpack();
            case "health", "hp" -> textObj.seeHealth(player1.getHealth());
            case "exit"->{
                textObj.exit();
                System.exit(0);
            }

        }

    }

    public void twoWordSwitch(String[] command) {
        switch (command[0]) {
            case "go", "g" -> {
                textObj.movement(command[1]);
                invalidRouteChecker(command[1]);
                playerMovement(command[1]);
            }
            case "take", "t" -> player1.takeItem(command[1]);
            case "eat" -> {
                player1.eatFood(command[1]);
                player1.checkFood(command[1]);
            }
            case "drop", "d" -> player1.dropItem(command[1]);

        }
    }

    //movement directionpicker
    public void playerMovement(String direction) {
        switch (direction) {

            case "north", "n" -> player1.moveNorth();
            case "south", "s" -> player1.moveSouth();
            case "west", "w" -> player1.moveWest();
            case "east", "e" -> player1.moveEast();
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
            default -> textObj.invalidInput();
        }
    }

}





