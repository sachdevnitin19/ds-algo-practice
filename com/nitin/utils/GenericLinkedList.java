package com.nitin.utils;

public class GenericLinkedList<T> {
    public GenericNode<T> head;
    int length = 0;

    public void insert(T nodeData) {
        GenericNode<T> newNode = new GenericNode<T>(nodeData);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            GenericNode<T> tempNode = this.head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        length++;
        return;
    }

    public void print() {
        GenericNode<T> tempNode = this.head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public boolean deleteNodeByPos(int pos) {
        if (this.head == null)
            return false;
        if (pos == 0) {
            this.head = this.head.next;
            this.length--;
            return true;
        }
        GenericNode<T> prev = null, curr = this.head;
        int ctr = 0;
        while (curr != null && ctr != pos) {
            prev = curr;
            curr = curr.next;
            ctr++;
        }
        if (curr == null)
            return false;
        prev.next = curr.next;
        curr.next = null;
        this.length--;
        return true;
    }

    public boolean deleteNodeByValue(T value) {
        if (this.head == null)
            return false;
        if (this.head.data == value) {
            this.head = this.head.next;
            this.length--;
            return true;
        }
        GenericNode<T> prev = null, curr = this.head;
        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return false;
        prev.next = curr.next;
        curr.next = null;
        this.length--;
        return true;
    }

    public void reverseList() {
        if (this.length == 0 || this.length == 1)
            return;
        GenericNode<T> slow = null, curr = this.head, fast = null;
        while (curr != null) {
            fast = curr.next;
            curr.next = slow;
            slow = curr;
            curr = fast;
        }
        this.head = slow;
    }
}