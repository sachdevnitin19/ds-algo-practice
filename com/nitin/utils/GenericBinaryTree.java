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

    public boolean doesNodeExists(T nodeDataToFind) {
        GenericBinaryTreeNode<T> nodeToFind = null;
        nodeToFind = this.findNodeRecursive(this.root, nodeDataToFind, nodeToFind);
        return nodeToFind != null;
    }

    public GenericBinaryTreeNode<T> findNodeRecursive(GenericBinaryTreeNode<T> root, T nodeValueToFind,
            GenericBinaryTreeNode<T> nodeToFind) {
        if (root == null) {
            return nodeToFind;
        }
        if (root.nodeData == nodeValueToFind) {
            nodeToFind = root;
            return nodeToFind;
        }
        GenericBinaryTreeNode<T> leftSubTreeResult = findNodeRecursive(root.left, nodeValueToFind, nodeToFind);
        GenericBinaryTreeNode<T> rightSubTreeResult = findNodeRecursive(root.right, nodeValueToFind, nodeToFind);
        return leftSubTreeResult != null ? leftSubTreeResult : rightSubTreeResult;
    }

    //class to maintain state while finding and deleting node recursively.
    private class nodeMaxLevel {
        int maxLevel;
        GenericBinaryTreeNode<T> deepestNode, deepestNodeParent, nodeToDelete;

        nodeMaxLevel() {
            this.maxLevel = 0;
            this.deepestNode = this.deepestNodeParent = nodeToDelete = null;
        }
    }

    //delete node in tree and replace it with rightmost deepest node
    //so that completeness of binary tree is maintained.
    public boolean deleteNodeRecursively(T deleteNodeData) {
        nodeMaxLevel deepNodeObj = new nodeMaxLevel();
        this.findNodesForDeletion(this.root, null, 1, deepNodeObj, false, deleteNodeData);
        if (deepNodeObj.nodeToDelete == null) {
            return false;
        }
        deepNodeObj.nodeToDelete.nodeData = deepNodeObj.deepestNode.nodeData;
        if (deepNodeObj.deepestNodeParent.left != null
                && deepNodeObj.deepestNodeParent.left.nodeData == deepNodeObj.deepestNode.nodeData) {
            deepNodeObj.deepestNodeParent.left = null;
        } else {
            deepNodeObj.deepestNodeParent.right = null;
        }
        return true;
    }

    //finds node which is to be deleted and deepest rightmost node
    private void findNodesForDeletion(GenericBinaryTreeNode<T> root, GenericBinaryTreeNode<T> parent, int levelSoFar,
            nodeMaxLevel maxLevelRef, boolean isRightNull, T nodeToFind) {
        if (root == null) {
            return;
        }

        if (levelSoFar >= maxLevelRef.maxLevel && isRightNull) {
            maxLevelRef.maxLevel = levelSoFar;
            maxLevelRef.deepestNode = root;
            maxLevelRef.deepestNodeParent = parent;
        }
        if (root.nodeData == nodeToFind) {
            maxLevelRef.nodeToDelete = root;
        }
        findNodesForDeletion(root.left, root, levelSoFar + 1, maxLevelRef, root.right == null, nodeToFind);
        findNodesForDeletion(root.right, root, levelSoFar + 1, maxLevelRef, root.right != null, nodeToFind);
    }

    public boolean isTreeSymmetric() {
        GenericQueue<GenericBinaryTreeNode<T>> BQ = new GenericQueue<GenericBinaryTreeNode<T>>();
        BQ.enqueue(this.root);
        BQ.enqueue(this.root);
        while (!BQ.isEmpty()) {
            GenericBinaryTreeNode<T> node1 = BQ.dequeue();
            GenericBinaryTreeNode<T> node2 = BQ.dequeue();
            if (node1.nodeData != node2.nodeData) {
                return false;
            }
            if (node1.left != null) {
                BQ.enqueue(node1.left);
            }
            if (node2.right != null) {
                BQ.enqueue(node2.right);
            }

            if (node2.left != null) {
                BQ.enqueue(node2.left);
            }
            if (node1.right != null) {
                BQ.enqueue(node1.right);
            }
        }
        return true;
    }

    public void convertToMirror() {
        convertToMirrorRecursively(this.root);
    }

    //recursive implementation of coverting tree to its binary image
    //doing post order traversal and swapping left and right child
    private void convertToMirrorRecursively(GenericBinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        convertToMirrorRecursively(root.left);
        convertToMirrorRecursively(root.right);
        GenericBinaryTreeNode<T> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //iterative implementation
    public void convertToMirrorIteratively() {
        GenericQueue<GenericBinaryTreeNode<T>> levelQueue = new GenericQueue<GenericBinaryTreeNode<T>>();
        levelQueue.enqueue(this.root);
        while (!levelQueue.isEmpty()) {
            int currLevel = levelQueue.length();
            while (currLevel-- > 0) {
                GenericBinaryTreeNode<T> currNode = levelQueue.dequeue();
                if (currNode != null) {
                    levelQueue.enqueue(currNode.left);
                    levelQueue.enqueue(currNode.right);
                    GenericBinaryTreeNode<T> temp = currNode.left;
                    currNode.left = currNode.right;
                    currNode.right = temp;
                }
            }
        }
    }
    //Check whether a binary tree is balance or not.
    //A balanced binary tree is defined as height difference between two leaf nodes is not 
    //greater than 1.

    class HeightState{
        int maxHeight;
        boolean isSubTreeBalanced;
        HeightState(){
            this.maxHeight=0;
            this.isSubTreeBalanced=false;
        }
    }
    public boolean isTreeBalanced() {
        HeightState treeHS = isSubTreeBalanced(root);
        return treeHS.isSubTreeBalanced;
    }

    public HeightState isSubTreeBalanced(GenericBinaryTreeNode<T> root) {
        HeightState HS=new HeightState();
        if (root == null) {
            HS.isSubTreeBalanced=true;
            return HS;
        }
        
        HeightState leftSubTreeHS = isSubTreeBalanced(root.left);
        if(!leftSubTreeHS.isSubTreeBalanced){
            return HS;
        }

        HeightState rightSubTreeHS = isSubTreeBalanced(root.right);
        if(!rightSubTreeHS.isSubTreeBalanced){
            return HS;
        }

        if(Math.abs(leftSubTreeHS.maxHeight-rightSubTreeHS.maxHeight)>1){
            return HS;
        }
        HS.maxHeight=(leftSubTreeHS.maxHeight>rightSubTreeHS.maxHeight?leftSubTreeHS.maxHeight:rightSubTreeHS.maxHeight)+1;
        HS.isSubTreeBalanced=true;
        return HS;
    }
}
