package org.example;

public class Main {

    public static void main(String[] args) {
//        SINGLY LIST
        LL list = new LL();
        list.insertFirst(23);
        list.insertFirst(32);
        list.insertFirst(54);
        list.insertFirst(12);
        list.insertFirst(4);
        list.insertLast(500);
        list.display();
        list.insert(100, 3);
        list.display();

//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println("Delete last");
//        list.deleteLast();
//        list.display();
//        System.out.println("Delete at index");
//        System.out.println(list.delete(2));
//        list.display();
//        System.out.println("Find the index of 54:"+ list.find(54) );
//        list.insertRec(111, 2);
        list.display();
        list.reverseBetween(2,4);
        list.display();


//      DOUBLY LINKED LIST
//        DLL list = new DLL();
//        list.insertFirst(23);
//        list.insertFirst(32);
//        list.insertFirst(54);
//        list.insertFirst(12);
//        list.insertFirst(4);
//        list.display();
//        System.out.println("Insert Last");
//        list.insertLast(100);
//        list.display();
//        System.out.println("Insert At index");
//        list.insert(500, 2);
//        list.display();
//        list.deleteFirst();
//        list.display();
//        System.out.println("Delete Last");
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println("Delete at index");
//        System.out.println(list.delete(1));
//        list.display();
//        System.out.println("index of 54: "+ 54);

//        CIRCULAR LINKED LIST
//        CLL list = new CLL();
//        list.insert(23);
//        list.insert(25);
//        list.insert(53);
//        list.insert(100);
//        list.display();
//        list.delete(25);
//        System.out.println("After delete 25");
//        list.display();

    }
}