package org.example;

import org.jetbrains.annotations.NotNull;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        size = 0;
    }

    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int data){
        if(tail == null){
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display(){
        Node temp = head;
        System.out.println("Start");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void insert(int data, int index){
        if(index == 0){
            insertLast(data);
            return;
        }
        if(index == size){
            insertLast(data);
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node node = new Node(data,temp.next);
        temp.next = node;
        size++;

    }

    public int deleteFirst(){
        int val = head.data;
        head  = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node find(int data){
        Node temp = head;
        while(temp != null){
            if(temp.data == data){
                return temp;
            }
            temp = temp.next;
        }
        return null;
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

    public int deleteLast(){
        int val = tail.data;
        if(size <= 1){
            return deleteFirst();
        }
        Node temp = tail;
        Node secondLast = get(size-2);
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){

        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }
    public void insertRec(int data, int index){
        head = insertRec(data,index, head);
    }
    private @NotNull Node insertRec(int data, int index, Node node){
        if(index == 0){
            Node temp = new Node(data, node);
            size++;
            return temp;
        }
        node.next = insertRec(data, index--, node.next);
        return node;
    }
    public void removeDuplicates(){
        if(head == null){
            return;
        }
        Node node = head;
        while(node != null){
            if(node.data == node.next.data){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        return head;
    }
    public Node mergeSortedLists(Node h1, Node h2){
        Node dummyhead = new Node();
        Node temp = dummyhead;
        while(h1 != null && h2 != null){
            if(h1.data < h2.data){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }
        temp.next = (h1 != null)? h1: h2;
        return dummyhead;
    }
    public void reverseBetween(int left, int right) {
        if(left == right){
            return ;
        }
        Node previous = null;
        Node current = head;
        for(int i = 0; current != null && i < left-1; i++){
            previous = current;
            current = current.next;
        }
        Node last = previous;
        Node newEnd = current;
        Node next = current.next;
//      reverse between left and rigth;
        for(int i = 0; current != null && i < right-left +1; i++){
            current.next = previous;
            previous = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        if(last != null){
            last.next = previous;
        }
        else {
            head = previous;
        }
        newEnd.next = current;
    }
    public Node middleNode(Node head){
        if(size <= 1){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;

        while (true) {

            Node check = curr;
            for (int i = 0; i < k; i++) {
                if (check == null)
                    return head;
                check = check.next;
            }

            Node last = prev;
            Node newEnd = curr;

            Node next = curr.next;
            for (int i = 0; i < k && curr != null; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = curr;
            if (curr == null)
                break;
            prev = newEnd;
        }
        return head;
    }
    public boolean isPalindrome(){
        Node mid =  middleNode(head);
        Node headSecond = reverseList(mid);
        Node reReverseHead = headSecond;

//        Compare both halves
        while(head != null && headSecond != null){
            if(head.data != headSecond.data){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reReverseHead);
        return head == null || headSecond == null;

    }
    public void reorderList(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node mid = middleNode(head);
        Node hf = head;
        Node hs = reverseList(mid);
        while(hf != null && hs != null){
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
//        setting the tail to null
        if(hf != null){
            hf.next = null;
        }
    }

}
