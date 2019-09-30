package com.nitin.utils;

public class GenericLinkedList<T> {
    GenericNode<T> head;
    int length=0;
    public void insert(T nodeData){
        GenericNode<T> newNode=new GenericNode<T>(nodeData);
        if(this.length==0){
            this.head=newNode;
        }else if(this.length==1){
            this.head.next=newNode;
        }else{
            GenericNode <T> tempNode=this.head;
            while(tempNode.next!=null){
                tempNode=tempNode.next;
            }
            tempNode.next=newNode;
        }
        length++;
        return;
    }

    public void print(){
        if(this.head==null){
            return;
        }else if(this.head.next==null){
            System.out.println(this.head.data);
        }else{
            GenericNode <T> tempNode=this.head;
            while(tempNode!=null){
                System.out.print(tempNode.data+" ");
                tempNode=tempNode.next;
            }
            System.out.println();
        }
    }

    public boolean deleteNodeByPos(int pos) {
        if (this.head == null)
            return false;
        if (pos == 0) {
            this.head = this.head.next;
            return true;
        }
        GenericNode<T> prev = null, curr = this.head;
        int ctr = 0;
        while (curr != null && ctr != pos) {
            prev = curr;
            curr = curr.next;
            ctr++;
        }
        if (curr == null)
            return false;
        prev.next = curr.next;
        curr.next = null;
        return true;
    }

    public boolean deleteNodeByValue(T value) {
        if (this.head == null)
            return false;
        if (this.head.data == value) {
            this.head = this.head.next;
            return true;
        }
        GenericNode<T> prev = null, curr = this.head;
        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return false;
        prev.next = curr.next;
        curr.next = null;
        return true;
    }
}