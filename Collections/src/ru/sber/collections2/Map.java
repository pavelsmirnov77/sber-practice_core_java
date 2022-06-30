package ru.sber.collections2;
import ru.sber.collections1.Collection;

public interface Map {
    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    Object get(Object key);
    Object put(Object key, Object value);
    Object remove(Object key);
    void clear();
    Collection values();
    Collection keySet();
    Collection entrySet();
}
