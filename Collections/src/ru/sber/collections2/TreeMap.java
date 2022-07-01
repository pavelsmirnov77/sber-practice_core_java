package ru.sber.collections2;

import ru.sber.collections1.Collection;
import ru.sber.collections1.ArrayList;
import ru.sber.collections1.Node;

public class TreeMap<K, V> implements Map<K, V> {
    private int size;
    private Node<Entry<K, V>> nodeRoot;
    private boolean search = false;

    public TreeMap() {
        nodeRoot = null;
        size = 0;
    }

    private K getKey(Node<Entry<K, V>> node) {
        return node.getValue().getKey();
    }

    private V getValue(Node<Entry<K, V>> node) {
        return node.getValue().getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {

        return searchKey(nodeRoot, key);
    }

    private boolean searchKey(Node<Entry<K, V>> child, K key) {
        if (key.equals(getKey(child))) {
            search = true;
        }
        if (child.getRight() != null && !search) {
            searchKey(child.getRight(), key);
        }
        if (child.getLeft() != null && !search) {
            searchKey(child.getLeft(), key);
        }
        return search;
    }

    @Override
    public boolean containsValue(V value) {
        search = false;
        return searchValue(nodeRoot, value);

    }

    private boolean searchValue(Node<Entry<K, V>> child, V value) {
        try{
            if (getValue(child).equals(value)) {
                search = true;
            }
        }catch(NullPointerException ex){
            if(value == null){
                search = true;
            }
        }
        if (child.getLeft() != null && !search) {
            searchValue(child.getLeft(), value);
        }
        if (child.getRight() != null && !search) {
            searchValue(child.getRight(), value);
        }
        return search;
    }

    @Override
    public V get(K key) {
        Node<Entry<K, V>> child = nodeRoot;
        while (true) {
            if (key.equals(getKey(child))) {
                return getValue(child);
            } else if (key.hashCode() < getKey(child).hashCode()) {
                child = child.getLeft();
                if (child == null) {
                    return null;
                }
            } else {
                child = child.getRight();
                if (child == null) {
                    return null;
                }
            }
        }
    }

    @Override
    public Entry<K, V> put(K key, V value) {
        Node<Entry<K, V>> newNode = new Node<>(new Entry<>(key, value));
        if (nodeRoot == null) {
            size++;
            nodeRoot = newNode;
        } else {
            Node<Entry<K, V>> parent;
            Node<Entry<K, V>> child = nodeRoot;
            while (true) {
                parent = child;
                if (getKey(child).equals(key)) {
                    child.setValue(new Entry<>(key, value));
                    return newNode.getValue();
                } else if (key.hashCode() < getKey(child).hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;

                        return newNode.getValue();
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return newNode.getValue();
                    }
                }
            }
        }
        return newNode.getValue();
    }

    @Override
    public V remove(K key) {
        Node<Entry<K, V>> currentNode = nodeRoot;
        Node<Entry<K, V>> parentNode = nodeRoot;

        boolean isLeft = true;

        while (!getKey(currentNode).equals(key)) {
            parentNode = currentNode;
            if (key.hashCode() < getKey(currentNode).hashCode()) {
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeft = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == nodeRoot) {
                nodeRoot = null;
            } else if (isLeft) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        }

        else if (currentNode.getRight() == null) {
            if (currentNode == nodeRoot) {
                nodeRoot = currentNode.getLeft();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        }

        else if (currentNode.getLeft() == null) {
            if (currentNode == nodeRoot) {
                nodeRoot = currentNode.getRight();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        }

        else {
            Node<Entry<K, V>> heir = replaceNode(currentNode);
            if (currentNode == nodeRoot) {
                nodeRoot = heir;
            } else if (isLeft) {
                parentNode.setLeft(heir);
            } else {
                parentNode.setRight(heir);
            }
        }
        size--;
        return getValue(currentNode);
    }

    private Node<Entry<K, V>> replaceNode(Node<Entry<K, V>> node) {
        Node<Entry<K, V>> heirNode = node;
        Node<Entry<K, V>> curNode = node.getRight();
        while (curNode != null) {
            heirNode = curNode;
            curNode = curNode.getLeft();
        }
        if (heirNode != node.getRight()) {
            curNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }

    @Override
    public void clear() throws NullPointerException {
        size = 0;
        nodeRoot = null;
        throw new NullPointerException("Дерево пустое");
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        addValue(nodeRoot, arrayList);
        return arrayList;
    }

    private void addValue(Node<Entry<K, V>> child, ArrayList<V> arrayList) {
        arrayList.add(getValue(child));
        if (child.getLeft() != null) {
            addValue(child.getLeft(), arrayList);
        }
        if (child.getRight() != null) {
            addValue(child.getRight(), arrayList);
        }
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> arrayList = new ArrayList<>();
        addKey(nodeRoot, arrayList);
        return arrayList;
    }

    private void addKey(Node<Entry<K, V>> child, ArrayList<K> li) {
        li.add(getKey(child));
        if (child.getLeft() != null) {
            addKey(child.getLeft(), li);
        }
        if (child.getRight() != null) {
            addKey(child.getRight(), li);
        }
    }

    @Override
    public Collection<Entry <K, V>> entrySet() {
        ArrayList<Entry<K, V>> arrayList = new ArrayList<>();
        addEntry(nodeRoot, arrayList);
        return arrayList;
    }

    private void addEntry(Node<Entry<K, V>> child, ArrayList<Entry<K, V>> li) {

        li.add(child.getValue());

        if (child.getLeft() != null)
            addEntry(child.getLeft(), li);

        if (child.getRight() != null)
            addEntry(child.getRight(), li);
    }
}
