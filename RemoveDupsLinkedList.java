import com.nitin.utils.GenericLinkedList;
import com.nitin.utils.GenericNode;
import java.util.*;

class RemoveDupsLinkedList {
    public static void main(String args[]) {
        GenericLinkedList<Integer> ll = new GenericLinkedList<Integer>();

        ll.insert(3);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);
        ll.insert(5);
        ll.insert(2);
        ll.insert(1);
        ll.insert(9);
        ll.insert(3);
        ll.insert(3);
        ll.print();
        removeDups(ll);
        ll.print();

        GenericLinkedList<Integer> ll2 = new GenericLinkedList<Integer>();
        ll2.insert(3);
        ll2.insert(3);
        ll2.insert(3);
        ll2.insert(3);
        ll2.insert(3);
        ll2.insert(3);
        ll2.insert(3);
        ll2.insert(3);
        ll2.print();
        removeDups(ll2);
        ll2.print();
    }

    public static void removeDups(GenericLinkedList<Integer> ll) {
        Set<Integer> dupRecords = new HashSet<Integer>();
        GenericNode<Integer> fastNode = ll.head, slowNode = null;
        while (fastNode != null) {
            if (!dupRecords.add(fastNode.data)) {
                slowNode.next = fastNode.next;
                fastNode.next = null;
                fastNode = slowNode.next;
            } else {
                slowNode = fastNode;
                fastNode = fastNode.next;
            }
        }
        slowNode = null;
    }
}