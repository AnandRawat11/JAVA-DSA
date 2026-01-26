package org.example;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    int end = -1;

    public CustomQueue() {
        this(DEFAULT_CAPACITY);
    }
    public CustomQueue(int size) {
        this.data = new int[size];
    }
    public boolean isFull() {
        return end == data.length - 1;
    }
    public boolean isEmpty() {
        return end == -1;
    }
    public boolean insert(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        data[++end] = item;
        return true;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[--end];
    }
    public int remove()throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[0];

//        Shift the elements to left
        for(int i = 1; i < end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    public int front(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[0];
    }
    public int back(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[data.length-1];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[end-1];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        for(int i = 0; i < end+1; i++){
            System.out.print(data[i]+" ");
        }

    }
}
