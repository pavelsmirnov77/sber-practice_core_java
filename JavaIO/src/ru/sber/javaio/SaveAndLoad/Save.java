package ru.sber.javaio.SaveAndLoad;

import ru.sber.javaio.SaveAndLoad.armor.CombatArmor;
import ru.sber.javaio.SaveAndLoad.weapon.Mace;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {
    public static void main(String[] args) throws IOException {
        Hero hero = new Hero("Herald");

        System.out.println(hero);

        hero.setLvl(14);
        hero.setArmor(new CombatArmor());
        hero.setWeapon(new Mace());

        System.out.println(hero);

        try (FileOutputStream outputStream = new FileOutputStream("JavaIO/src/ru/sber/javaio/SaveAndLoad/files/save.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(hero);
        }
    }
}
