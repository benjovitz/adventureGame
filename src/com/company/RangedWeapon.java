package com.company;

public class RangedWeapon extends Weapon{
    private int ammo;

    public RangedWeapon(String name, int damage,int ammo) {
        super(name, damage);
        this.ammo=ammo;
    }

    @Override
    public void ammoChecker() {
        if(getAmmo() == 0){
            System.out.println("you dont have amo");
        }else System.out.println("phew");
    }
    public void setAmmo(int ammo){
        this.ammo = ammo;

    }

    public int getAmmo(){
        return ammo;
    }

}
