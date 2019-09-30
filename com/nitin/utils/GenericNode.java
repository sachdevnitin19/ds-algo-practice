package com.nitin.utils;

public class GenericNode<T> {
    public T data;
    public GenericNode<T> next;

    public GenericNode(T nodeData) {
        this.data = nodeData;
    }
}