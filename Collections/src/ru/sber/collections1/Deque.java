package ru.sber.collections1;

public interface Deque<E> extends Collection<E> {
    void addFirst(E item);
    void addLast(E item);
    E getFirst();
    E getLast();
    E pollFirst();
    E pollLast();
    E removeFirst();
    E removeLast();
}
