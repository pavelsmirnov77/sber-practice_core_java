package ru.sber.collections1;

import java.util.NoSuchElementException;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        try {
            System.out.println(arrayList.isEmpty());

            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(4);
            arrayList.add(3);
            arrayList.add(8);
            arrayList.add(2,4);

            System.out.println(arrayList.isEmpty());

            arrayList.remove(2);

            System.out.println(arrayList.toString());

            System.out.println(arrayList.contains(4));

            arrayList.set(1,4);
            arrayList.set(1,5);

            System.out.println(arrayList.toString());

            System.out.println(arrayList.get(4));

            System.out.println(arrayList.indexOf(3));

            System.out.println(arrayList.lastIndexOf(8));

            System.out.println(arrayList.subList(1, 3));

            System.out.println(arrayList.toString());

            //arrayList.get(5);

            arrayList.clear();

            System.out.println(arrayList.toString());

            arrayList.get(5);

        } catch (NoSuchElementException exceptionNoSuchElement) {
            System.out.println(exceptionNoSuchElement.getMessage());
            exceptionNoSuchElement.printStackTrace();
        } catch (IndexOutOfBoundsException exceptionIndexOutOfBounds) {
            System.out.println(exceptionIndexOutOfBounds.getMessage());
            exceptionIndexOutOfBounds.printStackTrace();
        }
    }
}