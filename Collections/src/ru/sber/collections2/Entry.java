package ru.sber.collections2;

public class Entry {
    Object key;
    Object value;

    Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[key = " + key + ", value = " + value + ']';
    }
}
