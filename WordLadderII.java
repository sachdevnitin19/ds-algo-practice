import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class WordLadderII {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Solution soln = new Solution();

        System.out.println(soln.findLadders(beginWord, endWord, wordList));

    }

    static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(beginWord)) {
                wordList.add(beginWord);
            }

            WordGraph wg = new WordGraph(beginWord, endWord, wordList);
            wg.createWordGraph(wordList);

            // for(int itr=0;itr<wordList.length;itr++){}
            return wg.findAllLadders();
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
            static class WordGraphNode {
                String word;
                ArrayList<Integer> adjList;

                WordGraphNode(String nodeWord) {
                    this.word = nodeWord;
                    this.adjList = new ArrayList<>();

                }

            }

            ArrayList<WordGraphNode> wordGraphNodeList;
            int totalWords, beginWordIndex = -1, endWordIndex = -1;

            WordGraph(String beginWord, String endWord, List<String> wordList) {
                this.totalWords = wordList.size();

                this.wordGraphNodeList = new ArrayList<>();
                for (int itr = 0; itr < this.totalWords; itr++) {
                    if (this.beginWordIndex == -1 && beginWord.equals(wordList.get(itr))) {
                        this.beginWordIndex = itr;
                    }
                    if (this.endWordIndex == -1 && endWord.equals(wordList.get(itr))) {
                        endWordIndex = itr;
                    }
                    this.wordGraphNodeList.add(new WordGraphNode(wordList.get(itr)));
                }
                
            }

            public void createWordGraph(List<String> wordList) {
                for (int itr = 0; itr < wordList.size(); itr++) {
                    for (int innerItr = itr + 1; innerItr < wordList.size(); innerItr++) {
                        if (isOneDiffAway(wordList.get(itr), wordList.get(innerItr))) {
                            this.addEdge(itr, innerItr);
                        }
                    }
                }
            }

            public void addEdge(int src, int des) {
                this.wordGraphNodeList.get(src).adjList.add(des);
                this.wordGraphNodeList.get(des).adjList.add(src);
            }

            public List<List<String>> findAllLadders() {
                List<List<String>> allLadders = new ArrayList<>();
                HashSet<String> visitedNodes = new HashSet<>();
                ArrayList<String> currLadder = new ArrayList<>();
                dfsAndFindPaths(beginWordIndex, currLadder, allLadders, visitedNodes);
                return allLadders;
            }

            public void dfsAndFindPaths(int currNodeIndex, List<String> currLadder, List<List<String>> allLadders,
                    HashSet<String> visitedNodes) {
                WordGraphNode currWordGraphNode = this.wordGraphNodeList.get(currNodeIndex);
                String currWord = currWordGraphNode.word;

                if (currNodeIndex == endWordIndex) {
                    List<String> currLadderClone = new ArrayList<>(currLadder);
                    currLadderClone.add(currWord);
                    allLadders.add(currLadderClone);
                    return;
                }

                if (visitedNodes.contains(currWord)) {
                    return;
                }

                currLadder.add(currWord);
                visitedNodes.add(currWord);

                Iterator<Integer> adjListItr = currWordGraphNode.adjList.iterator();
                while (adjListItr.hasNext()) {
                    dfsAndFindPaths(adjListItr.next(), currLadder, allLadders, visitedNodes);
                }
                currLadder.remove(currWord);
            }
        }

    }

}
