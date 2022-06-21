package ru.sber.base.syntax;
public class Task5 {
    public static void main(String[] args) {
        System.out.print("Простые числа: ");
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= i; j++) {
                if (j < i  & i % j == 0) {
                    break;
                }
                if (i % j == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
