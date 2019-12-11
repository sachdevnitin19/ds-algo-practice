package com.nitin.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//undirected unweighted graph.
public class AdjacencyListGraph {
    int noOfVertices;
    SinglyLinkedList[] adjList;

    public AdjacencyListGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjList = new SinglyLinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            this.adjList[i] = new SinglyLinkedList();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjList[src].insert(dest);
        this.adjList[dest].insert(src);
    }

    public void printBFS() {
        HashSet<Integer> visitedNodes = new HashSet<Integer>();
        Queue<Integer> nodeToVisit = new LinkedList<Integer>();
        for (int i = 0; i < noOfVertices; i++) {
            if (!visitedNodes.contains(i)) {
                nodeToVisit.add(i);
                while (!nodeToVisit.isEmpty()) {
                    int currNode = nodeToVisit.remove();
                    if (!visitedNodes.contains(currNode)) {
                        visitedNodes.add(currNode);
                        Node ptr = this.adjList[currNode].head;
                        System.out.print(currNode + " ");
                        while (ptr != null) {
                            nodeToVisit.add(ptr.data);
                            ptr = ptr.next;
                        }
                    }
                }
            }
        }
        System.out.println();
    }
}