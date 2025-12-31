package org.example;

public class DLL {
    Node head;
    private int size;
    public DLL(){
        size = 0;
    }
    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int data){

        Node node = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
        size++;
    }

    public Node get(int index){
        if(index == 0){
            return head;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public void insert(int data, int index){
        if(index == 0){
            insertFirst(data);
        }
        if(index == size){
            insertLast(data);
        }
        Node node = new Node(data);
        Node previous = get(index-1);
        node.prev = previous;
        node.next = previous.next;
        previous.next = node;
        node.next.prev = node;
        size++;
    }

    public int deleteFirst(){
        int value = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return value;
    }
    public int deleteLast(){
        Node secondLast = get(size-2);
        int value = secondLast.next.data;
        secondLast.next.prev = null;
        secondLast.next = null;
        size--;
        return value;
    }
    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node previous = get(index-1);
        int value = previous.next.data;
        previous.next = previous.next.next;
        previous.next.prev = previous;
        size--;
        return value;
    }
    public Node find (int value){
        Node temp = head;
        while(temp.next != null){
            if(temp.data == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        System.out.println("In Normal order");
        while(temp != null){
            System.out.print(temp.data + " ");
            last = temp;
            temp = temp.next;

        }
        System.out.println("End");
//        System.out.println("In reverse order");
//        while(last != null){
//            System.out.print(last.data + " ");
//            last = last.prev;
//        }
//        System.out.println("Start");
    }

    private class Node{

        private int size;
        private Node prev;
        private Node next;
        private int data;
        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Node(int data) {
            this.data = data;
        }
    }

}
