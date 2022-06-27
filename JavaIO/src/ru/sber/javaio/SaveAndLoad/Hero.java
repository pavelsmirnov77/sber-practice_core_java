package ru.sber.javaio.SaveAndLoad;

import ru.sber.javaio.SaveAndLoad.armor.Armor;
import ru.sber.javaio.SaveAndLoad.armor.LightArmor;
import ru.sber.javaio.SaveAndLoad.weapon.Stick;
import ru.sber.javaio.SaveAndLoad.weapon.Weapon;

import java.io.Serializable;

public class Hero implements Serializable {
    String name;
    int lvl;
    Weapon weapon;
    Armor armor;

    public Hero(String name) {
        this.name = name;
        this.lvl = 1;
        this.weapon = new Stick();
        this.armor = new LightArmor();
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, уровень: %s, оружие: %s, броня: %s", name, lvl, weapon, armor);
    }
}
