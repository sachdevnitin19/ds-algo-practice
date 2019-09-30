package com.nitin.utils;

public class Stack {
    static final int MAX = 1000000;
    int top;
    char stackArr[] = new char[MAX];

    public Stack() {
        top = -1;
    }

    public boolean isStackFull() {
        return top >= MAX - 1;
    }

    public boolean isStackEmpty() {
        return top < 0;
    }

    public char peek() {
        return stackArr[top];
    }

    public boolean push(char x) {
        if (top >= MAX - 1) {
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

    public char pop() {
        char x = stackArr[top--];
        return x;
    }
}