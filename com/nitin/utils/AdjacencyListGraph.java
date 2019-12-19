package com.nitin.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//undirected unweighted graph.
public class AdjacencyListGraph {
    int noOfVertices;
    SinglyLinkedList[] adjList;
    boolean isGraphDirected;

    public AdjacencyListGraph(int noOfVertices, boolean isDirected) {
        this.noOfVertices = noOfVertices;
        this.isGraphDirected = isDirected;
        this.adjList = new SinglyLinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            this.adjList[i] = new SinglyLinkedList();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjList[src].insert(dest);
        if (!isGraphDirected) {
            this.adjList[dest].insert(src);
        }

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
    public boolean doesPathExists(int src, int dest){
        HashSet<Integer> visitedNode=new HashSet<Integer>();
        Queue<Integer> nodeToVisit=new LinkedList<Integer>();
        nodeToVisit.add(src);
        while(!nodeToVisit.isEmpty()){
            int currNode=nodeToVisit.remove();
            Node ptr=this.adjList[currNode].head;
            visitedNode.add(currNode);
            while(ptr!=null){
                if(ptr.data==dest){
                    return true;
                }
                if(!visitedNode.contains(ptr.data)){
                    nodeToVisit.add(ptr.data);    
                }
                ptr=ptr.next;
            }
        }
        
        return false;
    }
    public void printDFS() {
        HashSet<Integer> nodesVisited = new HashSet<Integer>();
        Stack<Integer> nodesStack = new Stack<Integer>();

        for (int i = 0; i < noOfVertices; i++) {
            if (!nodesVisited.contains(i)) {
                nodesStack.push(i);
                while (!nodesStack.isEmpty()) {
                    int currNode = nodesStack.pop();
                    if (!nodesVisited.contains(currNode)) {
                        System.out.print(currNode + " ");
                        nodesVisited.add(currNode);
                        Node ptr = this.adjList[currNode].head;
                        while (ptr != null) {
                            nodesStack.push(ptr.data);
                            ptr = ptr.next;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void printDFSRecursively() {
        HashSet<Integer> nodesVisited = new HashSet<Integer>();
        for (int i = 0; i < noOfVertices; i++) {
            dfsTraverse(i, nodesVisited);
        }
        System.out.println();
    }

    public void dfsTraverse(int vertice, HashSet<Integer> nodesVisited) {
        if (!nodesVisited.contains(vertice)) {
            System.out.print(vertice + " ");
            nodesVisited.add(vertice);
            Node ptr = this.adjList[vertice].head;
            while (ptr != null) {
                dfsTraverse(ptr.data, nodesVisited);
                ptr = ptr.next;
            }

        }
    }

    public boolean isGraphCyclic() {
        HashSet<Integer> nodesVisited = new HashSet<Integer>();
        HashSet<Integer> recursionSet = new HashSet<Integer>();
        for (int i = 0; i < noOfVertices; i++) {
            if (isGraphCyclicUtil(i, nodesVisited, recursionSet)) {
                return true;
            }
        }
        return false;
    }

    public boolean isGraphCyclicUtil(int vertice, HashSet<Integer> nodesVisited, HashSet<Integer> recursionSet) {
        if (recursionSet.contains(vertice)) {
            return true;
        }
        
        recursionSet.add(vertice);
        Node ptr = this.adjList[vertice].head;
        while (ptr != null) {
            if (!nodesVisited.contains(ptr.data)) {
                if (isGraphCyclicUtil(ptr.data, nodesVisited, recursionSet)) {
                    return true;
                }
            }

            ptr = ptr.next;
        }
        nodesVisited.add(vertice);
        recursionSet.remove(vertice);
        return false;
    }

    public String returnTopologicalOrder() {
        if (!isGraphDirected) {
            System.out.println("Topological sort order cannot be found for undirected graph");
            return "";
        }
        HashSet<Integer> nodesVisited = new HashSet<Integer>();
        Stack<Integer> topologicalOrderStack = new Stack<Integer>();
        try {
            for (int i = 0; i < noOfVertices; i++) {
                if (!nodesVisited.contains(i)) {
                    findTopologicalOrder(i, nodesVisited, topologicalOrderStack);
                }
            }
        } catch (CyclicGraphException e) {
            System.out.println(e.message);
            return "";
        }

        StringBuilder order = new StringBuilder();
        while (!topologicalOrderStack.isEmpty()) {
            order.append(topologicalOrderStack.pop() + " ");
        }
        return order.toString().trim();
    }

    public void findTopologicalOrder(int vertice, HashSet<Integer> nodesVisited, Stack<Integer> topologicalOrderStack)
            throws CyclicGraphException {
        if (nodesVisited.contains(vertice)) {
            throw new CyclicGraphException("Graph contains cycle");
        }
        nodesVisited.add(vertice);
        Node ptr = this.adjList[vertice].head;
        while (ptr != null) {
            if (!nodesVisited.contains(ptr.data)) {
                findTopologicalOrder(ptr.data, nodesVisited, topologicalOrderStack);
            }
            ptr = ptr.next;
        }
        topologicalOrderStack.push(vertice);
    }

    class CyclicGraphException extends Exception {
        private static final long serialVersionUID = 7718828512143293558L;
        public String message;

        CyclicGraphException(String message) {
            super(message);
            this.message = message;
        }
    }
}