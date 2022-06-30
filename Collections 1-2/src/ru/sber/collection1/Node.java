package ru.sber.collection1;

public class Node {
    Object item;
    Node next;
    Node prev;

    public Node(Node prev, Object item, Node next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }

    public Node() {
        this.prev = null;
        this.item = null;
        this.next = null;
    }
}
