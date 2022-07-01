package ru.sber.collections2;

import ru.sber.collections1.Collection;
import ru.sber.collections1.LinkedList;

import java.util.Arrays;

public class HashMap<K, V> implements Map<K, V> {

    private int size;
    private int rate;
    private LinkedList<Entry<K, V>>[] buckets;

    HashMap() {
        rate = 0;
        size = (int) Math.pow(2, rate);
        buckets = new LinkedList[size];
    }

    @Override
    public int size() {
        return rate+1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Entry<K, V> pair: linkedList) {
                if (key.equals(pair.key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedList<Entry<K, V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K, V> val : linkedList)
                    if (val.value.equals(value)) {
                        return true;
                    }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Entry<K, V> pair: linkedList) {
                if (key.equals(pair.key)) {
                    return pair.value;
                }
            }
        }
        return null;
    }

    @Override
    public Entry<K, V> put(K key, V value) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[bucketNumber];
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            linkedList.addLast(new Entry<>(key, value));
        }
        buckets[bucketNumber] = linkedList;
        for (Entry<K, V> pair: linkedList) {
            if (key.equals(pair.key)) {
                pair.value = value;
                return pair;
            }
        }
        linkedList.addLast(new Entry<>(key, value));
        rate++;
        return null;
    }

    @Override
    public V remove(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Entry<K, V> pair: linkedList) {
                if (key.equals(pair.key)) {
                    linkedList.remove(pair);
                    buckets[bucketNumber] = linkedList;
                    return pair.value;
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
    public Collection<V> values() {
        Collection<V> values = new LinkedList<>();
        for (LinkedList<Entry<K, V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K, V> val : linkedList) {
                    values.add(val.value);
                }
            }
        }
        return values;
    }

    @Override
    public Collection<K> keySet() {
        Collection<K> keys = new LinkedList<>();
        for (LinkedList<Entry<K, V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K, V> k : linkedList) {
                    keys.add(k.key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection<Entry<K, V>> entrySet() {
        Collection<Entry<K, V>> entryS = new LinkedList<>();
        for (LinkedList<Entry<K, V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K, V> entry : linkedList) {
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
