package com.nitin.utils;

public class GenericBinaryTreeNode<T> {
    T nodeData;
    public GenericBinaryTreeNode<T> left = null, right = null;

    public GenericBinaryTreeNode(T data) {
        this.nodeData = data;
    }
}