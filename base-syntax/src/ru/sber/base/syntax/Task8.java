package ru.sber.base.syntax;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args){
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        Scanner in = new Scanner(System.in);
        boolean out = false;
        for (int i = 0; i < 3; i++) {
            if (out) {
                break;
            }
            String answer = in.nextLine();
            switch (answer) {
                case("Троллейбус"):
                    System.out.println("Правильньно!");
                    out = true;
                    break;
                case("Сдаюсь"):
                    System.out.println("Правильный ответ: троллейбус");
                    out = true;
                    break;
                default:
                    System.out.println("Подумай еще");
            }
        }
    }
}
