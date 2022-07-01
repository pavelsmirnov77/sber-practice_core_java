package ru.sber.collections1;

public interface List<E> extends Collection<E> {
    void add(int index, E item);
    void set(int index, E item);
    E get(int index);
    int indexOf(E item);
    int lastIndexOf(E item);
    E remove(int index);
    List<E> subList(int from, int to);
}
