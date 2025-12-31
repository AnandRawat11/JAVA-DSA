package org.example;

public class Node {
    public int data;
    public Node next;
    public int size = 0;
    // constructor
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}
