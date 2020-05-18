import java.util.ArrayList;
import java.util.List;

class SearchProducts {
    public static void main(String[] args) {
        String[] products = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mozuse";
        Solution soln = new Solution();

        System.out.println(soln.suggestedProducts(products, searchWord));
    }

    static class Solution {

        class Trie {

            class TrieNode {
                TrieNode child[] = new TrieNode[26];
                String word;
            }

            TrieNode root, traversePtr;

            public Trie() {
                this.root = new TrieNode();
                this.traversePtr = this.root;
            }

            /** Inserts a word into the trie. */
            public void insert(String word) {

                TrieNode ptr = this.root;
                int wordItr = 0;
                char ch;
                while (wordItr < word.length()) {
                    ch = word.charAt(wordItr);
                    TrieNode ptrChild = ptr.child[ch - 'a'];
                    if (ptrChild == null) {
                        ptrChild = ptr.child[ch - 'a'] = new TrieNode();
                    }
                    ptr = ptrChild;
                    wordItr++;
                }
                ptr.word = word;
            }

            public List<String> returnSuggestions(char inputChar) {
                List<String> suggestions = new ArrayList<>();
                // performing dfs from this node, traversing upto 3 paths
                if (traversePtr != null) {
                    this.traversePtr = this.traversePtr.child[inputChar - 'a'];
                    dfsTraverse(traversePtr, suggestions);
                }
                return suggestions;
            }

            public void dfsTraverse(TrieNode node, List<String> suggestions) {
                if (node == null) {
                    return;
                }
                if (node.word != null) {
                    suggestions.add(node.word);
                }

                for (int itr = 0; itr < 26; itr++) {
                    if (suggestions.size() == 3) {
                        break;
                    }

                    if (node.child[itr] != null) {
                        dfsTraverse(node.child[itr], suggestions);
                    }

                }
            }
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Trie productsTrie = new Trie();
            for (String product : products) {
                productsTrie.insert(product);
            }
            List<List<String>> suggestions = new ArrayList<List<String>>();

            for (int subStrIndex = 0; subStrIndex < searchWord.length(); subStrIndex++) {
                suggestions.add(productsTrie.returnSuggestions(searchWord.charAt(subStrIndex)));
            }
            return suggestions;
        }
    }

}
