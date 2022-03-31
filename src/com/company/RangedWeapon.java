package com.company;

public class RangedWeapon extends Weapon{
    private int ammo;

    public RangedWeapon(String name, int damage,int ammo) {
        super(name, damage);
        this.ammo=ammo;
    }

    @Override
    public int getWeaponStatus() {
        if(getAmmo() == 0){
            return 0;
        }else
            setAmmo(getAmmo()-1);
            System.out.println("phew, you have " + getAmmo() + " left");
            return damage;
    }

    public void setAmmo(int ammo){
        this.ammo = ammo;

    }

    public int getAmmo(){
        return ammo;
    }
}
