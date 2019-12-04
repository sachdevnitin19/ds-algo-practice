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
        BT1.insert(10);

        // BT1.levelOrderTraversal();
        // BT1.convertToMirror();
        // BT1.convertToMirrorIteratively();
        // BT1.levelOrderTraversal();
        // System.out
        //         .println(BT1.doesNodeExists(4) ? "Node exists in Binary Tree" : "Node does not exists in Binary Tree");
        // System.out.println(BT1.deleteNodeRecursively(4) ? "Node Deleted" : "Node not found");
        // System.out
        //         .println(BT1.doesNodeExists(4) ? "Node exists in Binary Tree" : "Node does not exists in Binary Tree");
        // BT1.levelOrderTraversal();
        // System.out.println(BT1.isTreeSymmetric()?"Tree is Symmetric":"Tree is not Symmetric");
        System.out.println(BT1.isTreeBalanced()?"BT1 Tree is Balanced":"BT1 Tree is not Balanced");

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

        // BT2.levelOrderTraversal();
        // System.out
        //         .println(BT2.doesNodeExists(4) ? "Node exists in Binary Tree" : "Node does not exists in Binary Tree");
        // System.out.println(BT2.deleteNodeRecursively(4) ? "Node Deleted" : "Node not found");
        // System.out
        //         .println(BT2.doesNodeExists(4) ? "Node exists in Binary Tree" : "Node does not exists in Binary Tree");
        // BT2.levelOrderTraversal();
        // System.out.println(BT2.isTreeSymmetric()?"Tree is Symmetric":"Tree is not Symmetric");
        System.out.println(BT2.isTreeBalanced()?"BT2 Tree is Balanced":"BT2 Tree is not Balanced");

        GenericBinaryTree<Integer> BT3 = new GenericBinaryTree<Integer>();
        BT3.insert(1);
        BT3.insert(2);
        BT3.insert(2);
        BT3.insert(3);
        BT3.insert(4);
        BT3.insert(4);
        BT3.insert(3);

        // System.out.println(BT3.isTreeSymmetric()?"Tree is Symmetric":"Tree is not Symmetric");
        System.out.println(BT3.isTreeBalanced()?"BT3 Tree is Balanced":"BT3 Tree is not Balanced");
    }
}