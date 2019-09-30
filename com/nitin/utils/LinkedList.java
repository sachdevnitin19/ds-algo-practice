package com.nitin.utils;

public class LinkedList {
    public Node head;

    public void insert(int num) {
        if (this.head == null) {
            this.head = new Node(num);
            return;
        }
        Node ptr = this.head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node(num);
    }

    public int length() {
        if (this.head == null)
            return 0;
        Node ptr = this.head;
        int length = 0;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        return length;
    }

    public void print() {
        if (this.head == null)
            return;
        Node ptr = this.head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public boolean deleteNodeByPos(int pos) {
        if (this.head == null)
            return false;
        if (pos == 0) {
            this.head = this.head.next;
            return true;
        }
        Node prev = null, curr = this.head;
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
        return true;
    }

    public boolean deleteNodeByValue(int value) {
        if (this.head == null)
            return false;
        if (this.head.data == value) {
            this.head = this.head.next;
            return true;
        }
        Node prev = null, curr = this.head;
        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return false;
        prev.next = curr.next;
        curr.next = null;
        return true;
    }

    public void reverseLinkedList() {
        int length = this.length();
        if (length == 0 || length == 1)
            return;
        Node prev = null, curr = this.head, lead = null;
        while (curr != null) {
            lead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = lead;
        }
        this.head = prev;
        return;
    }
}