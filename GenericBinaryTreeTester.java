import com.nitin.utils.GenericBinaryTree;

class GenericBinaryTreeTester {
    public static void main(String args[]) {
        GenericBinaryTree<Integer> BT = new GenericBinaryTree<Integer>();

        BT.insert(1);
        BT.iterativeInOrderTraversal();
        BT.insert(2);
        BT.insert(3);
        BT.insert(4);
        BT.insert(5);
        BT.insert(6);
        BT.insert(7);

        BT.levelOrderTraversal();

        BT.iterativeInOrderTraversal();
    }
}