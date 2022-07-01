package ru.sber.collections1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    private int capacity = 10;
    private int size = 0;
    private Object[] arrayList = new Object[capacity];

    private Object[] resize() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] resizeArrayList = new Object[capacity];
        for (int i = 0; i < size; i++) {
            resizeArrayList[i] = arrayList[i];
        }
        return resizeArrayList;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        if (size > capacity) {
            arrayList[size] = item;
        }
        else {
            Object[] resizeArrayList = resize();
            resizeArrayList[size] = item;
            arrayList = resizeArrayList;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E item) {
        boolean foundElement = false;
        for (int i = 0; i < size; i++)
            if (arrayList[i].equals(item)) {
                i--;
                remove(i);
                foundElement = true;
            }
        return foundElement;
    }

    @Override
    public void clear() {
        arrayList = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(int index, E item) throws IndexOutOfBoundsException {
        if (size == capacity)
            arrayList = resize();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы списка");
        } else if (index == size) {
            arrayList[index] = item;
            size++;
        } else {
            for (int i = size; i > index; i--)
                arrayList[i] = arrayList[i - 1];
            arrayList[index] = item;
            size++;
        }
    }

    @Override
    public void set(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Вы вышли за пределы списка");
        else arrayList[index] = item;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new NoSuchElementException("В списке нет элементов");
        }
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Вы вышли за пределы списка");
        return (E) arrayList[index];
    }

    @Override
    public int indexOf(E item) {

        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы списка");
        }
        E element = (E) arrayList[index];
        for (int i = index; i < size; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public List<E> subList(int from, int to) throws IndexOutOfBoundsException {
        if ((from >= size) || (to - 1 >= size)) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы списка");
        }
        ArrayList<E> subArrayList = new ArrayList<>();
        for (int i = from; i < to; i++) {
            subArrayList.add(arrayList[i]);
        }
        return subArrayList;
    }

    private String printArrayList() {
        String elements = "";
        for (int i = 0; i < size; i++) {
            elements += arrayList[i];
            if (i + 1 < size) {
                elements += " ";
            }
        }
        return elements;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<>(this);
    }

    public String toString() {
        return String.format("ArrayList = %s", printArrayList());
    }
}
