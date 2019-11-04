package com.nitin.utils;

public class GenericBinaryTreeNode<T> {
    T nodeData;
    GenericBinaryTreeNode<T> left = null, right = null;

    public GenericBinaryTreeNode(T data) {
        this.nodeData = data;
    }
}