package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.mainMenu();
    }

    public void mainMenu() {

        //String filePath = "Ophira Zakai - Renaissance Lute.wav";
        String filePath2 = "Torch Burning Sound Effect.wav";
        String filePath ="magic lute.wav";
        Adventure obj = new Adventure() ;
        Map map = new Map();
        map.createRooms();
        obj.playMusic(filePath);
        Player player1 = new Player();







        //intro
        System.out.printf("You wake up drowzy and confused. The room your standing in is dimly lit room,\na fireplace is crackling and what appears to a magical lute is playing by itself in the corner");

        Scanner keyboard = new Scanner(System.in);
        boolean stillRunning = true;
        while (stillRunning) {

            String command = keyboard.nextLine();
            String switchCommand=command.substring(0,command.length()).toLowerCase(Locale.ROOT);


            switch (switchCommand) {
                case "north","go north","n":

                    if (map.starterRoom.getNorth() != null) {
                        map.starterRoom = map.starterRoom.getNorth();
                        System.out.println("going north");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else System.out.println("you cant go that way");
                    break;
                case "south","go south","s":
                    if (map.starterRoom.getSouth() != null) {
                        map.starterRoom = map.starterRoom.getSouth();
                        System.out.println("going south");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else System.out.println("you cant go that way");
                    break;
                case "west","go west","w":
                    if (map.starterRoom.getWest() != null) {
                        map.starterRoom = map.starterRoom.getWest();
                        System.out.println("going west");
                        if(map.starterRoom.getRoomBehavior() == 1) {
                            System.out.println(map.starterRoom.getDescription());
                            map.starterRoom.setRoomBehavior(0);
                        }
                    } else System.out.println("you cant go that way");
                    break;
                case "east","go east","e":
                    if (map.starterRoom.getEast() != null) {
                        map.starterRoom = map.starterRoom.getEast();
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

    //music
    public void playMusic(String musicLocation){
        try{
            File musicPath = new File(musicLocation);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                //JOptionPane.showMessageDialog(null, "The game is now beginning, press ok to start");
            }
            else{
                System.out.println("cant find file");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

}

