package ru.sber.collections1;
import java.util.NoSuchElementException;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        try {
            System.out.println("Двусвязный список пустой: " + linkedList.isEmpty());

            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(5);
            linkedList.add(4);
            linkedList.add(8);
            //linkedList.add("Collection");
            System.out.println("Вывод исходного двусвязного списка: " + linkedList.toString());

            System.out.println("Длина двусвяхного списка: " + linkedList.size());

            System.out.println("Двусвязный список пустой: " + linkedList.isEmpty());

            System.out.println("Проверка наличия числа 4 в двусвязном списке: " + linkedList.contains(4));

            linkedList.remove(2);
            //linkedList.remove("Collection");
            System.out.println("Вывод получившегося двусвязного списка после удаления элемента с индексом 2: " + linkedList);

            System.out.println("Первый элемент: " + linkedList.getFirst());

            System.out.println("Последний элемент: " + linkedList.getLast());

            System.out.println("Получаем первый элемент, затем удаляем его: " + linkedList.pollFirst());
            System.out.println("Двусвязный список после удаления первого элемента: " + linkedList.toString());
            System.out.println("Получаем последний элемент, затем удаляем его: " + linkedList.pollLast());
            System.out.println("Двусвязный список после удаления последнего элемента: " + linkedList.toString());

            linkedList.addFirst(0);

            linkedList.addLast(3);
            linkedList.addLast(4);

            System.out.println("Двусвязный список после добавления элементов в начало и конец: " + linkedList.toString());

            System.out.println("Элемент с индексом 2: " + linkedList.get(2));

            System.out.println("Индекс элемента со значением 3: " + linkedList.indexOf(3));

            System.out.println("Индекс последнего элемента числа 2 (то есть его индекс): " + linkedList.lastIndexOf(2));

            System.out.println("Вывод элементов на интервале [1; 3): " + linkedList.subList(1, 3));

            linkedList.clear();

            System.out.println("Двусвязный список после очистки: " + linkedList.toString());

            linkedList.remove(7);
        } catch (NoSuchElementException | IndexOutOfBoundsException exceptionNoSuchElement) {
            System.out.println(exceptionNoSuchElement.getMessage());
            exceptionNoSuchElement.printStackTrace();
        }
    }
}
