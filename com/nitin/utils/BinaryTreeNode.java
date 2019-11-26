package com.nitin.utils;

public class BinaryTreeNode {
    public BinaryTreeNode left, right;
    int nodeData;

    public BinaryTreeNode(int nodeData) {
        this.left = this.right = null;
        this.nodeData = nodeData;
    }
}