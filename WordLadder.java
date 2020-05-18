import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "log", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        System.out.println(wordList);
        int beginWordIndex = -1, endWordIndex = -1;

        WordGraph wg = new WordGraph(wordList.size());

        for (int itr = 0; itr < wordList.size(); itr++) {
            if (beginWordIndex == -1 && beginWord.equals(wordList.get(itr))) {
                beginWordIndex = itr;
            }
            if (endWordIndex == -1 && endWord.equals(wordList.get(itr))) {
                endWordIndex = itr;
            }
            for (int innerItr = itr + 1; innerItr < wordList.size(); innerItr++) {
                if (isOneDiffAway(wordList.get(itr), wordList.get(innerItr))) {
                    System.out.println("Adding edge for " + wordList.get(itr) + " -> " + wordList.get(innerItr));
                    wg.addEdge(itr, innerItr);
                }
            }
        }
        for (int itr = 0; itr < wordList.size(); itr++) {
            System.out.println(wg.adjList.get(itr));
        }
        System.out.println("min distance= " + wg.findMinDistance(beginWordIndex, endWordIndex));
    }

    public static boolean isOneDiffAway(String str1, String str2) {
        int diff = 0;
        for (int itr = 0; itr < str1.length(); itr++) {
            if (str1.charAt(itr) != str2.charAt(itr)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }

    static class WordGraph {
        ArrayList<ArrayList<Integer>> adjList;
        int totalWords;

        WordGraph(int totalWords) {
            this.totalWords = totalWords;
            this.adjList = new ArrayList<ArrayList<Integer>>(totalWords);
            for (int itr = 0; itr < totalWords; itr++) {
                this.adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int des) {
            this.adjList.get(src).add(des);
            this.adjList.get(des).add(src);
        }

        public int findMinDistance(int src, int des) {
            Queue<Integer> bfsQ = new LinkedList<>();
            HashSet<Integer> visitedNodes = new HashSet<>();
            int minDist = 1;
            bfsQ.add(src);
            while (!bfsQ.isEmpty()) {
                int totalNodesInQ = bfsQ.size();
                while (totalNodesInQ > 0) {
                    int currNode = bfsQ.remove();
                    if (currNode == des) {
                        return minDist;
                    }
                    visitedNodes.add(currNode);
                    Iterator<Integer> llItr = this.adjList.get(currNode).iterator();
                    while (llItr.hasNext()) {
                        int adjNode = llItr.next();
                        if (!visitedNodes.contains(adjNode)) {
                            bfsQ.add(adjNode);
                        }
                    }
                    totalNodesInQ--;
                }
                minDist++;
            }
            return 0;
        }

    }

}