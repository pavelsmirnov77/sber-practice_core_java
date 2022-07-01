package ru.sber.collections1;
import java.lang.Iterable;

public interface Collection<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(E item);
    boolean add(E item);
    boolean remove(E item);
    void clear();
}
