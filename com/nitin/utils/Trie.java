package com.nitin.utils;

public class Trie {

    class TrieNode {

        TrieNode child[] = new TrieNode[26];
        boolean isWord = false;
    }

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
                ptrChild = ptr.child[ch - 97] = new TrieNode();
            }
            ptr = ptrChild;
            i++;
        }

        ptr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = this.root;
        int wordLen = word.length(), i = 0;
        char ch;
        while (i < wordLen) {
            ch = word.charAt(i);
            TrieNode ptrChild = ptr.child[ch - 97];
            if (ptrChild == null) {
                break;
            }
            ptr = ptrChild;
            i++;
        }

        if (i < wordLen || !ptr.isWord) {
            return false;
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ptr = this.root;
        int prefixLen = prefix.length(), i = 0;
        char ch;
        while (i < prefixLen) {
            ch = prefix.charAt(i);
            TrieNode ptrChild = ptr.child[ch - 97];
            if (ptrChild == null) {
                break;
            }
            ptr = ptrChild;
            i++;
        }
        if (i < prefixLen) {
            return false;
        }

        return true;
    }
}
