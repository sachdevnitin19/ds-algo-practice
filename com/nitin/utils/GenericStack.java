package com.nitin.utils;

public class GenericStack<T> {
    GenericNode<T> top;

    public GenericStack() {
        this.top = null;
    }
    public T peek(){
        return this.top.data;
    }
    public boolean push(T data) {
        GenericNode<T> temp = new GenericNode<T>(data);
        if (this.top == null) {
            this.top = temp;
            return true;
        }
        temp.next = top;
        top = temp;
        return true;
    }

    public T pop() {
        T data = this.top.data;
        this.top = this.top.next;
        return data;
    }

    public boolean isStackEmpty() {
        return this.top == null;
    }

    public int stackLength() {
        GenericNode<T> ptr = this.top;
        int ctr = 0;
        while (ptr != null) {
            ctr++;
            ptr = ptr.next;
        }
        return ctr;
    }

}