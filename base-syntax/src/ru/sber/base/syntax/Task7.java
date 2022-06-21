package ru.sber.base.syntax;

public class Task7 {
    public static void main(String[] args) {
        int j = 0;
        int fibonacciFirst = 1;
        int fibonacciSecond = 1;
        int fibonacciSum = 0;
        System.out.print("Последовательность Фибоначчи: ");
        for (int i = 0; i < 11; i++) {
            if (i == 1 || i == 2) {
                System.out.print(1 + " ");
            }
            while (j < i-1) {
                fibonacciSum = fibonacciFirst + fibonacciSecond;
                fibonacciFirst = fibonacciSecond;
                fibonacciSecond = fibonacciSum;
                j += 1;
                System.out.print(fibonacciSecond + " ");
            }
        }
    }
}
