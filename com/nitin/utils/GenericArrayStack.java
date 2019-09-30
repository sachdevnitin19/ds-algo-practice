package com.nitin.utils;

public class GenericArrayStack<T> {

    private int top;
    private int stackSize;
    T stackArr[];

    @SuppressWarnings("unchecked")
    public GenericArrayStack(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[size];
        top = -1;
    }

    public boolean isStackFull() {
        return top >= this.stackSize - 1;
    }

    public boolean isStackEmpty() {
        return top < 0;
    }

    public T peek() {
        return stackArr[top];
    }

    public boolean push(T x) {
        if (top >= this.stackSize - 1) {
            System.out.println("stack full");
            return false;
        } else {
            stackArr[++top] = x;
            return true;
        }
    }

    public int stackLength() {
        return top < 0 ? 0 : top + 1;
    }

    public T pop() {
        return stackArr[top--];
    }
}