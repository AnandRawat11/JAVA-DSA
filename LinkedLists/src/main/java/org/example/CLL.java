package org.example;

public class CLL {
    private Node head;
    private Node tail;
    int size;
    public CLL(){
        this.head = null;
        this.tail = null;
    }
    public void display(){
        Node node = head;
        if(head != null){
            do{
                System.out.print(node.data+ " -->");
                node = node.next;
            } while(node != head);
        }
    }
    public void insert(int data){
        Node node = new Node(data);
        if(head == null){
            head = tail = node;
            return ;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;

    }
    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            return;
        }

        if (node.data == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (n.data == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);

    }
    public class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
