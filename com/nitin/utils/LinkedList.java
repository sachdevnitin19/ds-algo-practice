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


    public static Node MergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;

        middle.next = null;
        Node left = MergeSort(head);
        Node right = MergeSort(nextToMiddle);
        return MergeList(left, right);
    }

    public static Node MergeList(Node headA, Node headB) {
        Node mergedHead = new Node(0), tempPtr = mergedHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tempPtr.next = headA;
                headA = headA.next;
            } else {
                tempPtr.next = headB;
                headB = headB.next;
            }
            tempPtr=tempPtr.next;
        }
        while (headA != null) {
            tempPtr.next = headA;
            headA = headA.next;
            tempPtr=tempPtr.next;
        }

        while (headB != null) {
            tempPtr.next = headB;
            headB = headB.next;
            tempPtr=tempPtr.next;
        }
        return mergedHead.next;
    }

    public static Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}