package ru.sber.collections1;
import java.util.*;

public class ArrayListIterator implements Iterator<Object> {
    private ArrayList arrayList;
    private int i;

    public ArrayListIterator(ArrayList arrayList) {
        this.arrayList = arrayList;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < arrayList.size();
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (hasNext()) {
            i++;
            return arrayList.get(i-1);
        }
        else {
            throw new NoSuchElementException("В списке нет элементов");
        }
    }
}
