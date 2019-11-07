import com.nitin.utils.GenericBinaryTree;

class GenericBinaryTreeTester {
    public static void main(String args[]) {
        GenericBinaryTree<Integer> BT = new GenericBinaryTree<Integer>();

        BT.insert(1);
        BT.insert(2);
        BT.insert(3);
        BT.insert(4);
        BT.insert(5);
        BT.insert(6);
        BT.insert(7);
        BT.insert(8);
        // BT.insert(9);

        BT.levelOrderTraversal();
        System.out.println(BT.delete(7)?"Node deleted":"Node not found");
        BT.levelOrderTraversal();

    }
}