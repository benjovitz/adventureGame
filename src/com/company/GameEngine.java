package com.company;

import java.util.Locale;
import java.util.Scanner;

public class GameEngine {
    private final Player player1;
    private final Text textObj;
    private final Map map;
    private final Music music1;
    private final Scanner keyboard;
    private Enemy currentEnemy;


    public GameEngine() throws InterruptedException {
        textObj = new Text();
        player1 = new Player();
        player1.setHealth(100);
        map = new Map();
        music1 = new Music();
        keyboard = new Scanner(System.in);
        map.createWorld();
        //player placed in room 1
        player1.setPlayerPos(map.getStarterRoom());
        //intro text
        textObj.gameTextPrinter(textObj.intro());
    }

    public void mainMenu() throws InterruptedException {
        String answer = keyboard.nextLine().trim().toLowerCase(Locale.ROOT);
        switch (answer){
            case "yes","y" -> {
                textObj.gameTextPrinter(textObj.didHelp());
                String filePath = "8bit horror.wav";
                music1.playMusic(filePath);

                boolean stillRunning = true;
                while (stillRunning) {
                    if (player1.getHealth() <= 0) {
                        stillRunning = false;
                    }
                    String s = keyboard.nextLine().toLowerCase(Locale.ROOT).trim();
                    //splitting commands up
                    String[] command = s.split(" ");
                    menuPicker(command);
                }
            }
            case "no","n"-> {
                textObj.gameTextPrinter(textObj.didntHelp());
                System.exit(0);
            }
        }

    }

    public void menuPicker(String[] command) throws InterruptedException {
        if (command.length == 1) {
            oneWordSwitch(command);
        } else {
            twoWordSwitch(command);
        }

    }

    public void oneWordSwitch(String[] command) throws InterruptedException {
        switch (command[0]) {
            case "look", "l" -> {
                textObj.gameTextPrinter(player1.getCurrentRoom().getDescription());
                textObj.gameTextPrinter(player1.getCurrentRoom().getRoomItems());
                textObj.gameTextPrinter(player1.getCurrentRoom().getEnemies());
            }
            case "help", "h" -> textObj.gameTextPrinter(textObj.help());
            case "backpack", "b" -> player1.showBackpack();
            case "health", "hp" -> textObj.seeHealth(player1.getHealth());
            case "exit" -> {
                textObj.exit();
                System.exit(0);
            }
            default -> textObj.gameTextPrinter(textObj.invalidInput());
        }

    }

    public void twoWordSwitch(String[] command) throws InterruptedException {
        switch (command[0]) {
            case "go", "g" -> {
                textObj.gameTextPrinter(textObj.movement(command[1]));
                invalidRouteChecker(command[1]);
                playerMovement(command[1]);
            }
            case "attack", "a" -> {
                currentEnemy = player1.getCurrentRoom().findEnemy(command[1]);
                if (currentEnemy == null) {
                    textObj.gameTextPrinter("no enemies");
                } else {
                    currentEnemy.descriptionChecker();
                    currentEnemy.hit(player1.attackMove());
                    textObj.gameTextPrinter("enemy health " + currentEnemy.getHealth());
                    player1.hit(currentEnemy.attack());
                    textObj.gameTextPrinter("player health " + player1.getHealth());
                    if (currentEnemy.getHealth() <= 0) {
                        currentEnemy.finalBoos();
                        player1.getCurrentRoom().addRoomItem(currentEnemy.deathDrop());
                        player1.getCurrentRoom().removeEnemy(currentEnemy);
                        textObj.gameTextPrinter(textObj.deadEnemy(currentEnemy.getName()));
                    }
                }
            }
            case "take", "t" -> player1.takeItem(command[1]);
            case "eat" -> player1.eatFood(command[1]);
            case "drop", "d" -> player1.dropItem(command[1]);
            case "equip" -> player1.equipWeapon(command[1]);
            case "unequip" -> player1.unEquipWeapon(command[1]);
            case "specs" -> player1.findItemInBackpack(command[1]).specs();
            default -> textObj.gameTextPrinter(textObj.invalidInput());
        }

    }

    //movement directionpicker
    public void playerMovement(String direction) throws InterruptedException {
        switch (direction) {
            case "north", "n" -> player1.moveNorth();
            case "south", "s" -> player1.moveSouth();
            case "west", "w" -> player1.moveWest();
            case "east", "e" -> player1.moveEast();
            default -> textObj.gameTextPrinter(textObj.invalidInput());
        }

    }

    public void invalidRouteChecker(String direction) throws InterruptedException {
        switch (direction) {
            case "north", "n" -> {
                if (player1.getCurrentRoom().getNorth() == null) {
                    textObj.gameTextPrinter(textObj.invalidRoute());
                }
            }
            case "south", "s" -> {
                if (player1.getCurrentRoom().getSouth() == null) {
                    textObj.gameTextPrinter(textObj.invalidRoute());
                }
            }
            case "west", "w" -> {
                if (player1.getCurrentRoom().getWest() == null) {
                    textObj.gameTextPrinter(textObj.invalidRoute());
                }
            }
            case "east", "e" -> {
                if (player1.getCurrentRoom().getEast() == null) {
                    textObj.gameTextPrinter(textObj.invalidRoute());
                }
            }
            default -> textObj.gameTextPrinter(textObj.invalidInput());
        }
    }

}





