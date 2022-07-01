package ru.sber.collections1;
import java.util.*;

public class LinkedListIterator<E> implements Iterator<E> {

    private LinkedList<E> linkedList;
    private int i;

    public LinkedListIterator(LinkedList<E> linkedList) {
        this.linkedList = linkedList;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < linkedList.size();
    }

    @Override
    public E next() throws NoSuchElementException {
        if (hasNext()) {
            i++;
            return linkedList.get(i-1);
        }
        else {
            throw new NoSuchElementException("В полносвязном списке нет элементов");
        }
    }
}
