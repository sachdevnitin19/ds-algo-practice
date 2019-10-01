import java.io.IOException;

import com.nitin.utils.GenericLinkedList;

class GenericLinkedListTester{
    public static void main(String args[]) throws IOException{
        GenericLinkedList<Integer> l1=new GenericLinkedList<Integer>();
        l1.insert(1);
        l1.insert(2);
        l1.insert(3);
        l1.insert(4);
        l1.print();
        l1.reverseList();
        l1.print();
        l1.deleteNodeByPos(2);
        l1.print();
        l1.deleteNodeByValue(4);
        
        GenericLinkedList<Character> l2=new GenericLinkedList<Character>();
        l2.insert('a');
        l2.insert('b');
        l2.insert('c');
        l2.insert('d');
        l2.print();
        l2.deleteNodeByPos(2);
        l2.print();
        l2.deleteNodeByValue('d');
        l2.print();
    }
}