package ru.sber.collection1;
import java.util.*;

public class LinkedListIterator implements Iterator {

    private LinkedList linkedList;
    private int i;

    public LinkedListIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < linkedList.size();
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (hasNext()) {
            i++;
            return linkedList.get(i-1);
        }
        else {
            throw new NoSuchElementException("В полносвязном списке нет элементов");
        }
    }
}
