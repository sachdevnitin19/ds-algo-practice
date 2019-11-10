import com.nitin.utils.GenericBinaryTree;
import com.nitin.utils.GenericBinaryTreeNode;

class GenericBinaryTreeTester {
    public static void main(String args[]) {

        //example tree 1
        //      1
        //     /  \
        //    2     3
        //   / \   /  \
        //  4   5  6   7
        // / \
        // 8  9

        GenericBinaryTree<Integer> BT1 = new GenericBinaryTree<Integer>();
        BT1.insert(1);
        BT1.insert(2);
        BT1.insert(3);
        BT1.insert(4);
        BT1.insert(5);
        BT1.insert(6);
        BT1.insert(7);
        BT1.insert(8);
        BT1.insert(9);

        BT1.levelOrderTraversal();
        System.out.println("Rightmost leaf:- " + BT1.returnRightMostLeaf());

        //example tree 2
        //      1
        //     /  \
        //    2     3
        //   /
        //  4
        //  /
        //  5
        //   \
        //    6
        GenericBinaryTree<Integer> BT2 = new GenericBinaryTree<Integer>();
        BT2.root = new GenericBinaryTreeNode<Integer>(1);
        BT2.root.left = new GenericBinaryTreeNode<Integer>(2);
        BT2.root.right = new GenericBinaryTreeNode<Integer>(3);
        BT2.root.left.left = new GenericBinaryTreeNode<Integer>(4);
        BT2.root.left.left.left = new GenericBinaryTreeNode<Integer>(5);
        BT2.root.left.left.left.right = new GenericBinaryTreeNode<Integer>(6);

        BT2.levelOrderTraversal();
        System.out.println("Rightmost leaf:- " + BT2.returnRightMostLeaf());
    }
}