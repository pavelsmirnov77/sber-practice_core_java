package ru.sber.collections1;
import java.util.*;

public class ArrayListIterator<E> implements Iterator<E> {
    private ArrayList<E> arrayList;
    private int i;

    public ArrayListIterator(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < arrayList.size();
    }

    @Override
    public E next() throws NoSuchElementException {
        if (hasNext()) {
            i++;
            return arrayList.get(i-1);
        }
        else {
            throw new NoSuchElementException("В списке нет элементов");
        }
    }
}
