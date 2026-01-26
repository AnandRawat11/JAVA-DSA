package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue(5);
//        queue.insert(5);
//        queue.insert(2);
//        queue.insert(1);
//        queue.insert(23);
//        queue.display();
        circlularQueue queue = new circlularQueue(5);
        queue.insert(15);
        queue.insert(14);
        queue.insert(13);
        queue.insert(12);
        queue.insert(11);
        queue.display();
    }
}