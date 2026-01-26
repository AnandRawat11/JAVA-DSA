package org.example;

public class dynamicQueue extends circlularQueue {
    public dynamicQueue() {
        super();
    }
    public dynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(this.isFull()){
            int[] temp = new int[data.length *2];
//            System.arraycopy(data, 0, temp, 0, data.length);
            for(int j = 0; j < data.length; j++){
                temp[j] = data[(front+j)%data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
