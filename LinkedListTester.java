import java.io.*;
import com.nitin.utils.SinglyLinkedList;
import com.nitin.utils.Node;

class LinkedListTester {

    public static Node mergeSortedLinkedList(SinglyLinkedList l1, SinglyLinkedList l2) {
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

    public static boolean isPalindrome(SinglyLinkedList ll) {
        Node middleElement = SinglyLinkedList.getMiddle(ll.head);
        SinglyLinkedList llHalf = new SinglyLinkedList();
        llHalf.head = middleElement.next;
        middleElement.next = null;
        llHalf.reverseLinkedList();

        Node left = ll.head, right = llHalf.head;

        while (left!=null&&right!=null) {
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    };

    public static void main(String[] args) throws IOException {
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.insert(1);
        l1.insert(2);
        
        l1.print();

        System.out.println("Palindrome:-"+isPalindrome(l1));

        
    }
}