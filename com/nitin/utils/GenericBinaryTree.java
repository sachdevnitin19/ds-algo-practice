package com.nitin.utils;

public class GenericBinaryTree<T> {
    GenericBinaryTreeNode<T> root;

    public GenericBinaryTree() {
        this.root = null;
    }

    public GenericBinaryTree(T rootNodeData) {
        this.root = new GenericBinaryTreeNode<T>(rootNodeData);
    }

    public boolean insert(T data) {
        GenericBinaryTreeNode<T> insertNode = new GenericBinaryTreeNode<T>(data);
        if (this.root == null) {
            this.root = insertNode;
            return true;
        }
        GenericQueue<GenericBinaryTreeNode<T>> treeNodeQ = new GenericQueue<GenericBinaryTreeNode<T>>();
        treeNodeQ.enqueue(this.root);
        while (!treeNodeQ.isEmpty()) {
            GenericBinaryTreeNode<T> currNode = treeNodeQ.dequeue();
            if (currNode.left == null) {
                currNode.left = insertNode;
                return true;
            } else {
                treeNodeQ.enqueue(currNode.left);
            }

            if (currNode.right == null) {
                currNode.right = insertNode;
                return true;
            } else {
                treeNodeQ.enqueue(currNode.right);
            }
        }
        return true;
    }

    public void inOrderTraversal() {
        System.out.println("#### In Order Traversal ####");
        this.inOrderTraversal(this.root);
    }

    private void inOrderTraversal(GenericBinaryTreeNode<T> root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println("Node Data:- " + root.nodeData);
        inOrderTraversal(root.right);
    }

    public void iterativeInOrderTraversal() {
        System.out.println("#### Iterative In Order Traversal ####");
        if (this.root == null) {
            System.out.println("Tree is empty");
            return;
        } else {
            GenericStack<GenericBinaryTreeNode<T>> BTS = new GenericStack<GenericBinaryTreeNode<T>>();
            GenericBinaryTreeNode<T> ptr = this.root;

            while (ptr != null || !BTS.isStackEmpty()) {
                while (ptr != null) {
                    BTS.push(ptr);
                    ptr = ptr.left;
                }
                ptr = BTS.pop();
                System.out.println("Node data:- " + ptr.nodeData);
                ptr = ptr.right;
            }
        }
    }

    public void preOrderTraversal() {
        System.out.println("#### Pre Order Traversal ####");
        this.preOrderTraversal(this.root);
    }

    private void preOrderTraversal(GenericBinaryTreeNode<T> root) {
        if (root == null)
            return;
        System.out.println("Node Data:- " + root.nodeData);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal() {
        System.out.println("#### Post Order Traversal ####");
        this.postOrderTraversal(this.root);
    }

    private void postOrderTraversal(GenericBinaryTreeNode<T> root) {
        if (root == null)
            return;
        System.out.println("Node Data:- " + root.nodeData);
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
    }

    public void levelOrderTraversal() {
        System.out.println("#### Level Order Traversal ####");
        if (this.root == null) {
            System.out.println("Tree is empty");
            return;
        }
        GenericQueue<GenericBinaryTreeNode<T>> BTQ = new GenericQueue<GenericBinaryTreeNode<T>>();
        BTQ.enqueue(this.root);
        while (!BTQ.isEmpty()) {
            GenericBinaryTreeNode<T> currNode = BTQ.dequeue();

            if (currNode.left != null) {
                BTQ.enqueue(currNode.left);
            }
            if (currNode.right != null) {
                BTQ.enqueue(currNode.right);
            }
            System.out.println("NodeData:- " + currNode.nodeData);
        }
    }

}
