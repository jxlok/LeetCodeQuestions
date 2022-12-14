//Problem Statement:Design your implementation of the circular queue.
// The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out)
// principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
//
//One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
// In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front
// of the queue. But using the circular queue, we can use the space to store new values.
//
//Implementation the MyCircularQueue class:
//
//MyCircularQueue(k) Initializes the object with the size of the queue to be k.
//int Front() Gets the front item from the queue. If the queue is empty, return -1.
//int Rear() Gets the last item from the queue. If the queue is empty, return -1.
//boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
//boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
//boolean isEmpty() Checks whether the circular queue is empty or not.
//boolean isFull() Checks whether the circular queue is full or not.
//You must solve the problem without using the built-in queue data structure in your programming language.

public class CircularQueue {
    int[] queue;
    int size=0;
    int front =-1;
    int end = -1;
    int capacity;

    public CircularQueue(int k) {
        queue = new int[k];
        capacity=k;
    }

    public boolean enQueue(int value) {
        //if full, can't add
        if(this.isFull()){
            return false;
        }

        //if empty, iterate front
        if(this.isEmpty()){
            front=(front+1)%capacity;
        }

        //iterate end
        end=(end+1)%capacity;

        queue[end] = value;

        size++;

        return true;
    }

    public boolean deQueue() {
        //if empty, return false
        if(this.isEmpty()){
            return false;
        }

        front=(front+1)%capacity;

        size--;

        //empty after removal so reset
        if(this.isEmpty()){
            front=-1;
            end=-1;
        }
        return true;
    }

    public int Front() {
        //empty, return -1
        if(this.isEmpty()){
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }
        return queue[end];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==capacity;
    }
}
