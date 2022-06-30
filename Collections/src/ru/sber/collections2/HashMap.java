package ru.sber.collections2;

import ru.sber.collections1.Collection;
import ru.sber.collections1.LinkedList;

import java.util.Arrays;

public class HashMap implements Map {

    private int size;
    private LinkedList[] buckets;

    HashMap() {
        size = 1;
        buckets = new LinkedList[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else return false;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucketNumber = Math.abs(key.hashCode() % buckets.length);
        LinkedList linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Object pair: linkedList) {
                Entry entry = (Entry) pair;
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object val : linkedList) {
                    if (((Entry) val).value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int bucketNumber = Math.abs(key.hashCode() % buckets.length);
        LinkedList linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Object pair: linkedList) {
                Entry entry = (Entry) pair;
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int bucketNumber = Math.abs(key.hashCode() % buckets.length);
        LinkedList linkedList = buckets[bucketNumber];
        if (linkedList == null) {
            linkedList = new LinkedList();
            linkedList.addLast(new Entry(key, value));
        }
        buckets[bucketNumber] = linkedList;
        for (Object pair: linkedList) {
            Entry entry = (Entry) pair;
            if (entry.key.equals(key)) {
                entry.value = value;
                return entry;
            }
        }
        linkedList.addLast(new Entry(key, value));
        return null;
    }

    @Override
    public Object remove(Object key) {
        int bucketNumber = Math.abs(key.hashCode() % buckets.length);
        LinkedList linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Object pair: linkedList) {
                Entry entry = (Entry) pair;
                if (entry.key.equals(key)) {
                    linkedList.remove(pair);
                    buckets[bucketNumber] = linkedList;
                    return entry.value;
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            buckets[i] = null;
            size = 0;
        }
    }

    @Override
    public Collection values() {
        Collection values = new LinkedList();
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object val : linkedList) {
                    values.add(((Entry) val).value);
                }
            }
        }
        return values;
    }

    @Override
    public Collection keySet() {
        Collection keys = new LinkedList();
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object k : linkedList) {
                    keys.add(((Entry) k).key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection entrySet() {
        Collection entryS = new LinkedList();
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object entry : linkedList) {
                    entryS.add(entry);
                }
            }
        }
        return entryS;
    }

    @Override
    public String toString() {
        return "Hashmap = " + Arrays.toString(buckets);
    }
}
