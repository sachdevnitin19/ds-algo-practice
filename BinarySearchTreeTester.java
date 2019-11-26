import com.nitin.utils.BinarySearchTree;
import com.nitin.utils.BinaryTreeNode;
class BinarySearchTreeTester{
    public static void main(String args[]){
        BinarySearchTree BST=new BinarySearchTree();
        // BST.insert(7);
        // BST.insert(4);
        // BST.insert(10);
        // BST.insert(3);
        // BST.insert(5);
        // BST.insert(9);
        // BST.insert(12);
        // BST.insert(2);
        BST.root=new BinaryTreeNode(2);
        BST.root.left=new BinaryTreeNode(0);
        BST.root.right=new BinaryTreeNode(33);
        BST.root.right.left=new BinaryTreeNode(25);
        BST.root.right.right=new BinaryTreeNode(40);
        BST.root.right.right.right=new BinaryTreeNode(45);
        BST.root.right.right.left=new BinaryTreeNode(34);
        BST.root.right.right.left.right=new BinaryTreeNode(36);
        BST.root.right.right.left.right.left=new BinaryTreeNode(35);
        BST.root.right.right.left.right.right=new BinaryTreeNode(39);



        BST.printTree();
        System.out.println(BST.searchInTree(33)?"Node Found":"Node not Found");
        
        System.out.println(BST.deleteNodeV2(33)?"Node deleted":"Node not deleted");
        BST.printTree();
    }
}