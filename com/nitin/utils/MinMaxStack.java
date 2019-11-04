package com.nitin.utils;

public class MinMaxStack {
    Node top;
    private int maxElem = Integer.MIN_VALUE;
    private int minElem = Integer.MAX_VALUE;

    public MinMaxStack() {
        this.top = null;
    }

    public int getMaxValue() {
        return this.maxElem;
    }

    public int getMinValue() {
        return this.minElem;
    }

    public boolean push(int data) {
        Node tempNode;
        if (this.top == null) {
            this.maxElem = data;
            this.minElem = data;
            tempNode = new Node(data);
        } else if (data > this.maxElem) {
            tempNode = new Node(2 * data + this.maxElem);
            this.maxElem = data;
        } else if (data < this.minElem) {
            tempNode = new Node(2 * data - this.minElem);
            this.minElem = data;
        } else {
            tempNode = new Node(data);
        }
        tempNode.next = this.top;
        this.top = tempNode;
        return true;
    }

    public int peek() {
        return this.top.data;
    }

    public int pop() {
        int poppedNum;
        if (this.peek() > this.maxElem) {
            poppedNum = this.maxElem;
            this.maxElem = this.top.data - 2 * this.maxElem;
        } else if (this.peek() < this.minElem) {
            poppedNum = this.minElem;
            this.minElem = 2 * this.minElem + this.top.data;
        } else {
            poppedNum = this.top.data;
        }
        this.top = this.top.next;
        return poppedNum;
    }

}