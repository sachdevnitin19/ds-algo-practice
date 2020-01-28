/*
    Problem:- A complete binary tree i.e tree is completely filled except last level
    and all nodes are as far left as possible.
    Given total no of nodes "N" rooted at node id 1, left child id is 2*parent id and 
    right child node id is 2*parentid +1.
    Also given total no of queries "Q", each query is node id, 
    return total even node ids in subtree including that node.
    Example:-
    Input:-
    5 5
    1
    2
    3
    4
    5
    first line containse N and Q separated by space. Next Q lines contain a query i.e subtree node id.
    Tree;-
            1
           / \
          2   3
         / \
        4   5
    Output:-
    2  subtree starting from node 1 has 2 even nodes which are "2" and "4".
    2  subtree starting from node 2 has 2 even nodes which are "2" and "4".
    0  subtree starting from node 3 has 0 even nodes.
    1  subtree starting from node 4 has 1 even nodes which are "4".
    0  subtree starting from node 5 has 0 even nodes.
*/

import java.io.*;
import java.util.HashMap;

class CountEvenNodesInBinaryTree {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        long noOfNodes = Long.parseLong(tokens[0]);
        int totalQueries = Integer.parseInt(tokens[1]);
        long[] queryArr = new long[totalQueries];

        for (int i = 0; i < totalQueries; i++) {
            queryArr[i] = Long.parseLong(br.readLine());
        }
        solution(noOfNodes, queryArr);
    }

    public static void solution(long noOfNodes, long[] queryArr) {
        HashMap<Long, Long> memoization = new HashMap<Long, Long>();
        System.out.println("Result:-");
        for (long query : queryArr) {
            System.out.println("Total even nodes at subtree:- " + countEvenNodes(query, noOfNodes, memoization));
        }
    }
    //recursively traverse tree starting from that subtree node and counting even nodes 
    //and caching it so that it can be used in other upcoming queries.
    //Time Complexity:- O(n) where is total no of nodes.
    //Space Complexity:- O(n) where is total no of nodes.
    public static long countEvenNodes(long subTreeRoot, long noOfNodes, HashMap<Long, Long> memoization) {
        if (subTreeRoot > noOfNodes) {
            return 0;
        }
        if (memoization.get(subTreeRoot) != null) {
            return memoization.get(subTreeRoot);
        }

        long totalEvenNodes = countEvenNodes(2 * subTreeRoot, noOfNodes, memoization)
                + countEvenNodes(2 * subTreeRoot + 1, noOfNodes, memoization);
        if (subTreeRoot % 2 == 0) {
            totalEvenNodes += 1;
        }
        memoization.put(subTreeRoot, totalEvenNodes);
        return totalEvenNodes;
    }
}