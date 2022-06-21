package ru.sber.base.syntax;

public class Task4 {
    public static void main(String[] args) {
        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
            System.out.print(array[i] + " ");
        }
        System.out.println();
        double max = array[0];
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
            sum += array[i];
        }
        double avg = sum/array.length;
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + avg);
    }
}
