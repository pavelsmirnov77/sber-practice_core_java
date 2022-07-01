package ru.sber.collections1;

import java.sql.SQLOutput;
import java.util.NoSuchElementException;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(4);
            arrayList.add(3);
            arrayList.add(8);
            arrayList.add(2,4);

            System.out.println("Список пустой: " + arrayList.isEmpty());

            System.out.println("Вывод исходного списка: " + arrayList.toString());

            System.out.println("Размер списка: " + arrayList.size());

            arrayList.remove(2);

            System.out.println("Вывод списка после удаления элемента с индексом 2: " + arrayList.toString());

            System.out.println("Наличие числа 4: " + arrayList.contains(4));

            arrayList.set(1,5);

            System.out.println("Список после замены элемента с индексом 1: " + arrayList.toString());

            System.out.println("Получаем элемент с индексом 4: " + arrayList.get(4));

            System.out.println("Получаем индекс числа 3: " + arrayList.indexOf(3));

            System.out.println("Получаем последний индекс числа 8 (то есть его индекс): " + arrayList.lastIndexOf(8));

            System.out.println("Вывод элементов на интервале [1; 3): " + arrayList.subList(1, 3));

            arrayList.clear();

            System.out.println("Вывод списка после очистки: " + arrayList.toString());

            arrayList.get(5);

        } catch (NoSuchElementException | IndexOutOfBoundsException exceptionNoSuchElement) {
            System.out.println(exceptionNoSuchElement.getMessage());
            exceptionNoSuchElement.printStackTrace();
        }
    }
}