package ru.sber.collections1;

public class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    private E value;
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;

    public Node(Node<E> prev, E item, Node<E> next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
    public Node() {
        this.prev = null;
        this.item = null;
        this.next = null;
    }

    public Node(E value) {
        this.value = value;
        right = null;
        left = null;
        parent = null;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
