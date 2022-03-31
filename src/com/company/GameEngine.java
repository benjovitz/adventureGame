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
    }

    public void mainMenu() {
        boolean stillRunning = true;
        while (stillRunning || player1.getHealth() >= 0) {
            String s = keyboard.nextLine().toLowerCase(Locale.ROOT).trim();
            //splitting commands up
            String[] command = s.split(" ");
            menuPicker(command);
        }
    }

    public void menuPicker(String[] command) {
        if (command.length == 1) {
            oneWordSwitch(command);
        } else {
            twoWordSwitch(command);
        }

    }

    public void oneWordSwitch(String[] command) {
        switch (command[0]) {
            case "look", "l" -> {
                System.out.println(player1.getCurrentRoom().getDescription());
                System.out.println(player1.getCurrentRoom().getRoomItems());
                System.out.println(player1.getCurrentRoom().getEnemies());
            }
            case "help", "h" -> textObj.help();
            case "backpack", "b" -> player1.showBackpack();
            case "health", "hp" -> textObj.seeHealth(player1.getHealth());
            case "exit" -> {
                textObj.exit();
                System.exit(0);
            }
            default -> textObj.invalidInput();
        }

    }

    public void twoWordSwitch(String[] command) {
        switch (command[0]) {
            case "go", "g" -> {
                textObj.movement(command[1]);
                invalidRouteChecker(command[1]);
                playerMovement(command[1]);
            }
            case "attack", "a" -> {
                currentEnemy = player1.getCurrentRoom().findEnemy(command[1]);
                if (currentEnemy == null) {
                    System.out.println("no enemies");
                } else {
                    currentEnemy.hit(player1.attackMove());
                    System.out.println("enemy health " + currentEnemy.getHealth());
                    player1.hit(currentEnemy.attack());
                    System.out.println("player health " + player1.getHealth());
                    if (currentEnemy.getHealth() <= 0) {
                        player1.getCurrentRoom().addRoomItem(currentEnemy.deathDrop());
                        player1.getCurrentRoom().removeEnemy(currentEnemy);
                    }
                }
                //battleSwitch(command);
            }
            case "take", "t" -> player1.takeItem(command[1]);
            case "eat" -> player1.eatFood(command[1]);
            case "drop", "d" -> player1.dropItem(command[1]);
            case "equip" -> player1.equipWeapon(command[1]);
            case "unequip" -> player1.unEquipWeapon(command[1]);
            default -> textObj.invalidInput();
        }

    }
    /*public void battleSwitch(String[]command){
        boolean inCombat=true;

        while (inCombat){
            if(player1.getHealth()<0||currentEnemy.getHealth()<0){
                inCombat=false;
            }
            switch (command[0]){
                case "attack","a" ->{
                    currentEnemy=player1.getCurrentRoom().findEnemy(command[1]);
                    System.out.println(currentEnemy.getHealth());
                }
            }
            currentEnemy.hit(player1.attackMove());
        }
    }*/

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





