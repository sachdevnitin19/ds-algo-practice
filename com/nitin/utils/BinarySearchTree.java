package com.nitin.utils;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class BinarySearchTree {
    public BinaryTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean insert(int nodeData) {
        BinaryTreeNode newNode = new BinaryTreeNode(nodeData);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        insertRecursive(root, newNode);
        return true;
    }

    private void insertRecursive(BinaryTreeNode root, BinaryTreeNode newNode) {
        if (root.nodeData >= newNode.nodeData) {
            if (root.left == null) {
                root.left = newNode;
                return;
            }
            insertRecursive(root.left, newNode);
        } else {
            if (root.right == null) {
                root.right = newNode;
                return;
            }
            insertRecursive(root.right, newNode);
        }
    }

    public void printTree() {
        Queue<BinaryTreeNode> BSQ = new LinkedList<BinaryTreeNode>();
        BSQ.add(this.root);
        while (!BSQ.isEmpty()) {
            BinaryTreeNode currNode = BSQ.remove();
            System.out.println("Node Data:- " + currNode.nodeData);
            if (currNode.left != null) {
                BSQ.add(currNode.left);
            }
            if (currNode.right != null) {
                BSQ.add(currNode.right);
            }
        }
    }

    public boolean searchInTree(int numToSearch) {
        return searchInTree(root, numToSearch) != null ? true : false;
    }

    private BinaryTreeNode searchInTree(BinaryTreeNode root, int numToSearch) {
        if (root == null) {
            return null;
        } else if (root.nodeData > numToSearch) {
            return searchInTree(root.left, numToSearch);
        } else if (root.nodeData < numToSearch) {
            return searchInTree(root.right, numToSearch);
        }
        return root;
    }

    public boolean deleteNode(int numToDelete) {
        System.out.printf("#### Node to delete:- %d", numToDelete);
        System.out.println();
        if (this.root == null) {
            return false;
        }
        BinaryTreeNode parentPtr = null, nodeToDelete = this.root;
        while (nodeToDelete != null) {
            if (nodeToDelete.nodeData == numToDelete) {
                break;
            } else if (nodeToDelete.nodeData > numToDelete) {
                parentPtr = nodeToDelete;
                nodeToDelete = nodeToDelete.left;
            } else if (nodeToDelete.nodeData < numToDelete) {
                parentPtr = nodeToDelete;
                nodeToDelete = nodeToDelete.right;
            }
        }
        if (nodeToDelete == null) {
            return false;
        }
        //if node to be deleted is leaf node.
        if (nodeToDelete.left == null && nodeToDelete.right == null) {
            if (parentPtr.left == nodeToDelete) {
                parentPtr.left = null;
            } else {
                parentPtr.right = null;
            }
        } else if (nodeToDelete.left == null || nodeToDelete.right == null) {
            BinaryTreeNode deleteNodeChild = nodeToDelete.left != null ? nodeToDelete.left : nodeToDelete.right;
            if (parentPtr == null) {
                this.root = deleteNodeChild;
            }
            if (parentPtr.left == nodeToDelete) {
                parentPtr.left = deleteNodeChild;
            } else {
                parentPtr.right = deleteNodeChild;
            }
        } else {
            System.out.println("Finding successor");
            BinaryTreeNode inOrderSuccessor = nodeToDelete.right;
            while (inOrderSuccessor.left != null) {
                inOrderSuccessor = inOrderSuccessor.left;
            }
            deleteNode(inOrderSuccessor.nodeData);
            nodeToDelete.nodeData = inOrderSuccessor.nodeData;
        }
        return true;
    }

    public boolean deleteNodeV2(int numToDelete) {
        System.out.printf("#### Node to delete:- %d", numToDelete);
        System.out.println();
        if (this.root == null) {
            return false;
        }
        BinaryTreeNode parentPtr = null, nodeToDelete = this.root;
        while (nodeToDelete != null) {
            if (nodeToDelete.nodeData == numToDelete) {
                break;
            }
            parentPtr = nodeToDelete;
            if (nodeToDelete.nodeData > numToDelete) {
                nodeToDelete = nodeToDelete.left;
            } else if (nodeToDelete.nodeData < numToDelete) {
                nodeToDelete = nodeToDelete.right;
            }
        }
        if (nodeToDelete == null) {
            return false;
        }
        if (parentPtr == null) {
            deleteRootNode(nodeToDelete);
        }
        if (parentPtr.left == nodeToDelete) {
            parentPtr.left = deleteRootNode(nodeToDelete);
        } else {
            parentPtr.right = deleteRootNode(nodeToDelete);
        }
        return true;
    }

    public BinaryTreeNode deleteRootNode(BinaryTreeNode root) {
        if(root.left==null&&root.right==null){
            return null;
        }
        if(root.right==null){
            return root.left;
        }
        if(root.left==null){
            return root.right;
        }
        BinaryTreeNode succParent=null,succ=root.right;
        while(succ.left!=null){
            succParent=succ;
            succ=succ.left;
        }
        root.nodeData=succ.nodeData;
        if(succParent!=null){
            succParent.left=succ.right;
        }else{
            root.right=succ.right;
        }
        return root;
    }

    public static boolean isValidBSTIterative(BinaryTreeNode root) {
        if(root==null){
            return true;
        }
        Stack<BinaryTreeNode> inOrderStack=new Stack<>();
        BinaryTreeNode ptr=root;
        double inOrderElem=-Double.MAX_VALUE;
        while(ptr!=null||!inOrderStack.isEmpty()){
            while(ptr!=null){
                inOrderStack.push(ptr);
                ptr=ptr.left;
            }
            ptr=inOrderStack.pop();
            if(ptr.nodeData<=inOrderElem){
                return false;
            }
            inOrderElem=ptr.nodeData;
            ptr=ptr.right;
        }
        return true;
    }

    public boolean isValidBST(BinaryTreeNode root) {
        return checkValidityRecursively(root, -Double.MAX_VALUE,Double.MAX_VALUE);
    }
    private boolean checkValidityRecursively(BinaryTreeNode root, double min, double max){
        if(root==null){
            return true;
        }
        if(root.nodeData<=min){
            return false;
        }
        if(root.nodeData>=max){
            return false;
        }
        
        return checkValidityRecursively(root.left,min,root.nodeData) && checkValidityRecursively(root.right,root.nodeData,max);
        
    }

}