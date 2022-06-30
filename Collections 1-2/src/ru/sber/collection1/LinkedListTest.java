package ru.sber.collection1;
import java.util.NoSuchElementException;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        try {
            System.out.println(linkedList.isEmpty());

            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(5);
            linkedList.add(4);
            linkedList.add(8);
            linkedList.add("Collection");
            System.out.println(linkedList.toString());

            System.out.println(linkedList.isEmpty());

            System.out.println(linkedList.contains(4));

            System.out.println(linkedList);
            linkedList.remove(2);
            linkedList.remove("Collection");
            System.out.println(linkedList);

            System.out.println(linkedList.getFirst());

            System.out.println(linkedList.getLast());

            System.out.println(linkedList.pollFirst());
            System.out.println(linkedList.pollLast());

            linkedList.addFirst(0);

            linkedList.addLast(3);
            linkedList.addLast(4);

            System.out.println(linkedList.toString());

            System.out.println(linkedList.get(2));

            System.out.println(linkedList.indexOf(3));

            System.out.println(linkedList.lastIndexOf(2));

            System.out.println(linkedList.subList(1, 3));

            linkedList.clear();

            System.out.println(linkedList.toString());

            linkedList.remove(7);
        } catch (NoSuchElementException exceptionNoSuchElement) {
            System.out.println(exceptionNoSuchElement.getMessage());
            exceptionNoSuchElement.printStackTrace();
        } catch (IndexOutOfBoundsException exceptionIndexOutOfBounds) {
            System.out.println(exceptionIndexOutOfBounds.getMessage());
            exceptionIndexOutOfBounds.printStackTrace();
        }
    }
}
