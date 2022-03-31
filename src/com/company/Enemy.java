package com.company;

public class Enemy {
    private String name;
    private int health;
    private Weapon currentWeapon;
    private boolean descriptionChecker;
    private String description;
    //private Room currentRoom;

    public Enemy(String name,String description, int health, Weapon currentWeapon){
        this.name = name;
        this.health = health;
        this.currentWeapon = currentWeapon;
        this.description=description;
        this.descriptionChecker=true;
        //this.currentRoom = currentRoom;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return name;

    }
    public void hit(int damage){
        setHealth(getHealth()-damage);
    }

    public Weapon deathDrop(){
        return currentWeapon;
    }
    public int attack(){
        return currentWeapon.getWeaponStatus();
    }
    public void descriptionChecker(){
        if(descriptionChecker==true)
            System.out.println("Enemy appeared " + description);
        descriptionChecker=false;
    }
    public void finalBoos(){
        if(name.equals("peter")){
            if(getHealth()<=0){
                System.out.printf("\nyou beat Peter, well done\nHe was the son of bitch who took my sunglasses, thanks for the help stranger");
                System.exit(0);
            }
        }
    }
}
