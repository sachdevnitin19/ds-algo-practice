/*
Leetcode word break II solution:
https://leetcode.com/problems/word-search-ii/submissions/
*/ 

import java.util.*;

class WordBreak {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 's', 'l', 'v' } };
        String words[] = new String[] { "oath", "oaths", "pea", "eat", "rain" };
        System.out.println(sol.findWords(board, words));
    }
}

class Solution {

    int totalRows, totalCols;

    char[][] board;
    String[] words;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;

        this.totalRows = board.length;
        this.totalCols = board[0].length;

        Trie dictTrie = new Trie();
        for (String word : this.words) {
            dictTrie.insert(word);
        }
        List<String> result = new ArrayList<>();

        for (int row = 0; row < this.totalRows; row++) {
            for (int col = 0; col < this.totalCols; col++) {
                startDFS(row, col, dictTrie.root, result);
            }
        }
        return result;
    }

    void startDFS(int row, int col,  TrieNode prevPrefixNode, List<String> result) {
        // out of boundary
        if (row < 0 || row == this.totalRows || col < 0 || col == this.totalCols) {
            return;
        }
        char currBoardChar = this.board[row][col];

        // already used
        if (currBoardChar == '1') {
            return;
        }
        TrieNode currTrieNode = prevPrefixNode.child[currBoardChar - 'a'];
        // if using currBoardChar we cannot make word from dict
        if (currTrieNode == null) {
            return;
        }
        
        if (currTrieNode.word!=null) {
            // if word of dict is formed with currBoardChar and prefixStr
            result.add(currTrieNode.word);
            currTrieNode.word=null;
        }
        this.board[row][col] = '1';

        startDFS(row, col - 1, currTrieNode, result);
        startDFS(row - 1, col, currTrieNode, result);
         startDFS(row, col + 1, currTrieNode, result);
         startDFS(row + 1, col, currTrieNode, result);

        this.board[row][col] = currBoardChar;
    }

    static class TrieNode {
        TrieNode child[] = new TrieNode[26];
        String word = null;
    }

    static public class Trie {

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            int wordLen = word.length();
            TrieNode ptr = this.root;
            int i = 0;
            char ch;
            while (i < wordLen) {
                ch = word.charAt(i);
                TrieNode ptrChild = ptr.child[ch - 97];
                if (ptrChild == null) {
                    ptrChild=ptr.child[ch - 97] = new TrieNode();
                }
                ptr = ptrChild;
                i++;
            }

            ptr.word = word;
        }

    }

}

