package org.example;

import java.util.Queue;

public class circlularQueue extends CustomQueue {
    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    protected int end = 0;
    protected int front = 0;
    int size = 0;

    public circlularQueue() {
        this(DEFAULT_CAPACITY);
    }
    public circlularQueue(int size) {
        this.data = new int[size];
    }
    public boolean isFull() {
        return end == data.length - 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end] = item;
        end = (end + 1) % data.length;
        size++;
        return true;
    }
    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int removed = data[front];
        front = front % data.length;
        size--;
        return removed;
    }
    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        int count = 0;

        while (count < size) {
            System.out.print(data[i] + " ");
            i = (i + 1) % data.length;
            count++;
        }
        System.out.println();
        System.out.println("END OF QUEUE");
    }
}
