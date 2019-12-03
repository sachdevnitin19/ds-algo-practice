package com.nitin.utils;

// public class Trie {
//     class TrieNode {
//         char nodeChar;
//         TrieNode child[] = new TrieNode[26];
//         boolean isEnding = false;

//         TrieNode(char ch) {
//             this.nodeChar = ch;
//         }
//     }

//     TrieNode root;

//     public Trie() {
//         this.root = new TrieNode('*');
//     }

//     public void insertStr(String str) {
//         str = str.toLowerCase();
//         int strLen = str.length();
//         TrieNode ptr = this.root;
//         int i = 0;
//         char ch = str.charAt(i);
//         while (!ptr.isEnding && i < strLen) {
//             TrieNode ptrChild = ptr.child[ch - 97];
//             if (ptrChild == null) {
//                 break;
//             }
//             ptr = ptrChild;
//             ch = str.charAt(i++);
//         }
//         ptr.isEnding = false;
//         while (i < strLen) {
//             ptr.child[ch - 97] = new TrieNode(ch);
//             ptr = ptr.child[ch - 97];
//             ch = str.charAt(i++);
//         }
//         ptr.isEnding = true;
//     }

//     public boolean search(String str) {
//         str = str.toLowerCase();
//         TrieNode ptr = this.root;
//         int strLen = str.length(), i = 0;
//         char ch = str.charAt(i);
//         while (!ptr.isEnding && i < strLen) {
//             TrieNode ptrChild = ptr.child[ch - 97];
//             if (ptrChild == null) {
//                 break;
//             }
//             ptr = ptrChild;
//             ch = str.charAt(i++);
//         }
//         if (i < strLen) {
//             return false;
//         }
//         return true;
//     }

//     public boolean startsWith(String str) {
//         str = str.toLowerCase();
//         TrieNode ptr = this.root;
//         int strLen = str.length(), i = 0;
//         char ch = str.charAt(i);
//         while (!ptr.isEnding && i < strLen) {
//             TrieNode ptrChild = ptr.child[ch - 97];
//             if (ptrChild == null) {
//                 break;
//             }
//             ptr = ptrChild;
//             ch = str.charAt(i++);
//         }
//         if (i < strLen || ptr.isEnding) {
//             return false;
//         }

//         return true;
//     }
// }


public class Trie {
    
    class TrieNode {
        
        TrieNode child[] = new TrieNode[26];
        boolean isWord = false;
        
        TrieNode() {
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        System.out.println("Inserting "+word);
        int wordLen = word.length();
        TrieNode ptr = this.root;
        int i = 0;
        char ch = word.charAt(i);
        while (i < wordLen) {
            System.out.println(i);
            TrieNode ptrChild = ptr.child[ch - 97];
            if (ptrChild == null) {
                break;
            }
            ptr = ptrChild;
            ch = word.charAt(i++);
        }
        ptr.isWord=false;
        System.out.println("starting insert");
        while (i < wordLen) {
            System.out.println(i);
            ptr.child[ch - 97] = new TrieNode();
            ptr = ptr.child[ch - 97];
            ch = word.charAt(i++);
        }
        ptr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        System.out.println("Searching word "+word);
        TrieNode ptr = this.root;
        int wordLen = word.length(), i = 0;
        char ch;
        while (i < wordLen) {
            ch = word.charAt(i);
            System.out.println("i="+i+" ch="+ch);
            TrieNode ptrChild = ptr.child[ch - 97];
            System.out.println("ptrChild="+ptrChild+" ch-97="+(ch-97));
            if (ptrChild == null) {
                break;
            }
            ptr = ptrChild;
            i++;
        }

        System.out.println("AFTER i="+i+" ptr.isWord="+ptr.isWord);
        if (i < wordLen || !ptr.isWord) {
            return false;
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode ptr = this.root;
        int prefixLen = prefix.length(), i = 0;
        char ch = prefix.charAt(i);
        while ( i < prefixLen) {
            TrieNode ptrChild = ptr.child[ch - 97];
            if (ptrChild == null) {
                break;
            }
            ptr = ptrChild;
            ch = prefix.charAt(i++);
        }
        if (i < prefixLen) {
            return false;
        }

        return true;
    }
}

