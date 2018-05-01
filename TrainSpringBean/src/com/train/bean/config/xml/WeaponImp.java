package com.train.bean.config.xml;

public class WeaponImp implements Weapon {


    private Gun gun;


    public WeaponImp() {

    }

    public WeaponImp(Gun gun) {
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void shoot() {
        gun.shoot();
    }
}
