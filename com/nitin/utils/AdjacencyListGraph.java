package com.nitin.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;

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

    public boolean doesPathExists(int src, int dest) {
        HashSet<Integer> visitedNode = new HashSet<Integer>();
        Queue<Integer> nodeToVisit = new LinkedList<Integer>();
        nodeToVisit.add(src);
        while (!nodeToVisit.isEmpty()) {
            int currNode = nodeToVisit.remove();
            Node ptr = this.adjList[currNode].head;
            visitedNode.add(currNode);
            while (ptr != null) {
                if (ptr.data == dest) {
                    return true;
                }
                if (!visitedNode.contains(ptr.data)) {
                    nodeToVisit.add(ptr.data);
                }
                ptr = ptr.next;
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
            if (!nodesVisited.contains(i)) {
                dfsTraverse(i, nodesVisited);
            }
        }
        System.out.println();
    }

    public void dfsTraverse(int vertice, HashSet<Integer> nodesVisited) {

        System.out.print(vertice + " ");
        nodesVisited.add(vertice);
        Node ptr = this.adjList[vertice].head;
        while (ptr != null) {
            dfsTraverse(ptr.data, nodesVisited);
            ptr = ptr.next;
        }

    }

    public boolean isGraphCyclic() {
        HashSet<Integer> nodesVisited = new HashSet<Integer>();
        HashSet<Integer> recursionSet = new HashSet<Integer>();
        for (int i = 0; i < noOfVertices; i++) {
            if (nodesVisited.contains(i)) {
                continue;
            }
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
        HashSet<Integer> recurSet = new HashSet<>();

        Stack<Integer> topologicalOrderStack = new Stack<Integer>();
        try {
            for (int i = 0; i < noOfVertices; i++) {
                if (!nodesVisited.contains(i)) {
                    System.out.println("starting from " + i);
                    findTopologicalOrder(i, recurSet, nodesVisited, topologicalOrderStack);
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

    public void findTopologicalOrder(int vertice, HashSet<Integer> recurSet, HashSet<Integer> nodesVisited,
            Stack<Integer> topologicalOrderStack) throws CyclicGraphException {

        if (recurSet.contains(vertice)) {
            throw new CyclicGraphException("Graph contains cycle");
        }

        recurSet.add(vertice);
        Node ptr = this.adjList[vertice].head;
        while (ptr != null) {
            if (!nodesVisited.contains(ptr.data)) {
                findTopologicalOrder(ptr.data, recurSet, nodesVisited, topologicalOrderStack);
            }
            ptr = ptr.next;
        }
        recurSet.remove(vertice);
        nodesVisited.add(vertice);
        topologicalOrderStack.push(vertice);
    }

    class CyclicGraphException extends Exception {
        public String message;

        CyclicGraphException(String message) {
            super(message);
            this.message = message;
        }
    }
    //Brute force algorithm to find articulate points
    public List<Integer> findArticulationPoints() {
        List<Integer> articulationPoints = new ArrayList<>();
        for (int itr = 0; itr < noOfVertices; itr++) {
            
            if(isArticulatePoint(itr)){
                articulationPoints.add(itr);
            }
        }
        return articulationPoints;
    }

    public boolean isArticulatePoint(int nodeToCheck) {
        Stack<Integer> dfsStack = new Stack<>();

        for (int nodeIndex = 0; nodeIndex < this.noOfVertices; nodeIndex++) {
            if (nodeIndex == nodeToCheck) {
                continue;
            }
            HashSet<Integer> recurSet = new HashSet<>();
            dfsStack.push(nodeIndex);

            while (!dfsStack.isEmpty()) {
                int currNode = dfsStack.pop();
                if (currNode == nodeToCheck || recurSet.contains(currNode)) {
                    continue;
                }
                recurSet.add(currNode);
                if (recurSet.size() == this.noOfVertices - 1) {
                    return false;
                }

                Node ptr = this.adjList[currNode].head;
                while (ptr != null) {
                    dfsStack.push(ptr.data);
                    ptr = ptr.next;
                }
            }
        }
        return true;
    }

}