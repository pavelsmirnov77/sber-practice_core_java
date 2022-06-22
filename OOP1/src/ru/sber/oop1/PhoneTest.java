package ru.sber.oop1;

public class PhoneTest {
    public static void main(String[] args) {
        Phone phoneXiaomi = new Phone("89538151788","Xiaomi",100.4);
        Phone phonePoco = new Phone("89535748384","POCO");
        Phone phoneApple = new Phone();

        phoneXiaomi.receiveCall("Мама");
        phonePoco.receiveCall("Папа", "89212432443");
        phoneApple.sendMessage("89003234348", "89218538494", "89003234345");

        System.out.println(phoneXiaomi.getNumber());

        System.out.println(phoneXiaomi.toString());
        System.out.println(phonePoco.toString());
        System.out.println(phoneApple.toString());
    }
}
