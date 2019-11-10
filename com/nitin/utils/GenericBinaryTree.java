package com.nitin.utils;

public class GenericBinaryTree<T> {
    public GenericBinaryTreeNode<T> root;

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

    public boolean delete(T deleteNodeData) {
        System.out.println("delete node started");
        if (this.root == null) {
            return false;
        }
        GenericBinaryTreeNode<T> nodeToBeDeleted = null, secondLastLeafNode = null, lastLeafNode = null,
                currNode = null;
        GenericQueue<GenericBinaryTreeNode<T>> BQ = new GenericQueue<GenericBinaryTreeNode<T>>();
        BQ.enqueue(this.root);
        while (!BQ.isEmpty()) {
            currNode = BQ.dequeue();
            if (currNode.nodeData == deleteNodeData) {
                nodeToBeDeleted = currNode;
            }
            if (currNode.left != null) {
                BQ.enqueue(currNode.left);
            }
            if (currNode.right != null) {
                BQ.enqueue(currNode.right);
            }
            if (currNode.right != null && currNode.right.left == null && currNode.right.right == null) {
                secondLastLeafNode = currNode;
                lastLeafNode = currNode.right;
            } else if (currNode.left != null && currNode.left.left == null && currNode.left.right == null) {
                secondLastLeafNode = currNode;
                lastLeafNode = currNode.left;
            }
        }
        if (nodeToBeDeleted == null) {
            // node not found
            return false;
        }
        nodeToBeDeleted.nodeData = lastLeafNode.nodeData;
        System.out.println(
                "secondLastLeafNode= " + secondLastLeafNode.nodeData + "lastLeafNode= " + lastLeafNode.nodeData);
        if (secondLastLeafNode.right == lastLeafNode) {
            secondLastLeafNode.right = null;
        } else {
            secondLastLeafNode.left = null;
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

    public int maxDepth() {
        return this.maxDepth(this.root);
    }

    private int maxDepth(GenericBinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        } else {
            int lSubTreeDepth = maxDepth(root.left);
            int rSubTreeDepth = maxDepth(root.right);

            return Math.max(lSubTreeDepth, rSubTreeDepth) + 1;
        }
    }

    public int iterativeMaxDepth() {
        int maxTreeDepth = 0;
        GenericQueue<GenericBinaryTreeNode<T>> BTQ = new GenericQueue<GenericBinaryTreeNode<T>>();
        BTQ.enqueue(this.root);
        while (!BTQ.isEmpty()) {
            int currLevelNodesCount = BTQ.length();
            maxTreeDepth++;
            while (currLevelNodesCount-- > 0) {
                GenericBinaryTreeNode<T> currNode = BTQ.dequeue();
                if (currNode.left != null) {
                    BTQ.enqueue(currNode.left);
                }
                if (currNode.right != null) {
                    BTQ.enqueue(currNode.right);
                }
            }
        }
        return maxTreeDepth;
    }

    private class nodeMaxLevel {
        int maxLevel;
        GenericBinaryTreeNode<T> deepestNode, deepestNodeParent;

        nodeMaxLevel() {
            this.maxLevel = 0;
            this.deepestNode = this.deepestNodeParent = null;
        }
    }

    public T returnRightMostLeaf() {
        nodeMaxLevel maxLevelRef = new nodeMaxLevel();
        this.returnRightMostLeaf(this.root, null, 1, maxLevelRef, false);
        System.out.println("#### Deepest Node parent:- " + maxLevelRef.deepestNodeParent.nodeData + " DeepestNode:- "
                + maxLevelRef.deepestNode.nodeData);
        return maxLevelRef.deepestNode.nodeData;
    }

    public void returnRightMostLeaf(GenericBinaryTreeNode<T> root, GenericBinaryTreeNode<T> parent, int levelSoFar,
            nodeMaxLevel maxLevelRef, boolean isRightNull) {
        if (root == null) {
            return;
        }

        if (levelSoFar >= maxLevelRef.maxLevel && isRightNull) {
            maxLevelRef.maxLevel = levelSoFar;
            maxLevelRef.deepestNode = root;
            maxLevelRef.deepestNodeParent = parent;
        }

        returnRightMostLeaf(root.left, root, levelSoFar + 1, maxLevelRef, root.right == null);
        returnRightMostLeaf(root.right, root, levelSoFar + 1, maxLevelRef, root.right != null);
    }
}
