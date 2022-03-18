package com.company;

public class Text {

    public void intro(){
        System.out.printf("You wake up drowzy and confused. The room your standing in is a dimly lit room,\na fireplace is crackling and what appears to a magical lute is playing by itself in the corner\n");

    }

    public void help(){
        System.out.print("this is the help transscript, you can go north, south, east or west." +
                " Enter either: go" +
                "south; east; north; west.");
        System.out.println("  to look around type: look");

    }

    public void exit(){
        System.out.println("exit game");
    }

    public void invalidRoute(){
        System.out.println("You cant go that way");
    }
    public void invalidInput(){
        System.out.println("Invalid input");
    }
    public void movement (String direction){

        System.out.println("Going " + direction);
    }

}
