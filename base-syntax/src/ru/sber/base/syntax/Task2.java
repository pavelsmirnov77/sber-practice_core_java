package ru.sber.base.syntax;
public class Task2 {
    public static void quickSort(int[] array, int left, int right) {

        int mid = left + (right - left) / 2;
        int midElem = array[mid];

        int i = left, j = right;
        while (i <= j) {
            while (array[i] < midElem) {
                i++;
            }
            while (array[j] > midElem) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j)
            quickSort(array, left, j);
        if (right > i)
            quickSort(array, i, right);
    }
    public static void main(String[] args) {
        int[] array = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.print("Исходный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        System.out.print("Отсортированный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
