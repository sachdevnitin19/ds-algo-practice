import java.io.*;
import com.nitin.utils.*;

class LinkedListTester {
    
    public static Node mergeSortedLinkedList(LinkedList l1, LinkedList l2) {
        Node finalListHead = new Node(0), tmp = finalListHead;

        while (l1.head != null && l2.head != null) {
            if (l1.head.data < l2.head.data) {
                tmp.next = l1.head;
                l1.head = l1.head.next;
                tmp = tmp.next;
                tmp.next = null;

            } else {
                tmp.next = l2.head;
                l2.head = l2.head.next;
                tmp = tmp.next;
                tmp.next = null;
            }
        }
        while (l1.head != null) {
            tmp.next = l1.head;
            l1.head = l1.head.next;
            tmp = tmp.next;
            tmp.next = null;
        }

        while (l2.head != null) {
            tmp.next = l2.head;
            l2.head = l2.head.next;
            tmp = tmp.next;
            tmp.next = null;
        }
        finalListHead = finalListHead.next;
        return finalListHead;
    }

    public static void main(String[] args) throws IOException {
        LinkedList l1 = new LinkedList();
        l1.insert(1);
        l1.insert(2);
        l1.insert(4);
        System.out.println("Linked list length=" + l1.length());
        l1.print();

        LinkedList l2 = new LinkedList();
        l2.insert(1);
        l2.insert(3);
        l2.insert(4);
        l2.print();

        LinkedList mergedList = new LinkedList();
        mergedList.head = mergeSortedLinkedList(l1, l2);

        mergedList.print();
        System.out.println("Merged Linked list length=" + mergedList.length());
    }
}