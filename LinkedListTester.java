import java.io.*;
import com.nitin.utils.LinkedList;
import com.nitin.utils.Node;

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

    public static boolean isPalindrome(LinkedList ll) {
        Node middleElement = LinkedList.getMiddle(ll.head);
        LinkedList llHalf = new LinkedList();
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
        LinkedList l1 = new LinkedList();
        l1.insert(1);
        l1.insert(2);
        
        l1.print();

        System.out.println("Palindrome:-"+isPalindrome(l1));

        
    }
}