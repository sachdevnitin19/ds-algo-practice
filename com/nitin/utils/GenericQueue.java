package com.nitin.utils;

public class GenericQueue<T> {
    GenericNode<T> head, tail;

    public GenericQueue() {
        this.head = this.tail = null;
    }

    public boolean enqueue(T data) {
        GenericNode<T> temp = new GenericNode<T>(data);
        if (this.tail == null && this.head == null) {
            this.tail = this.head = temp;
        } else {
            this.tail.next = temp;
            this.tail = this.tail.next;
        }
        return true;
    }

    public T dequeue() {
        if (this.head == null && this.tail == null) {
            System.out.println("Queue is empty");
            return null;
        } else {
            GenericNode<T> temp = this.head;
            if (this.head == this.tail) {
                this.head = this.tail = null;
            } else {
                this.head = this.head.next;
            }
            return temp.data;
        }
    }

    public int length() {
        GenericNode<T> ptr = this.head;
        int ctr = 0;
        while (ptr != null) {
            ctr++;
            ptr = ptr.next;
        }
        return ctr;
    }

    public void printQueue() {
        GenericNode<T> ptr = this.head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }
}