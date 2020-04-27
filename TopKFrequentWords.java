import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class TopKFrequentWords {
    public static void main(String args[]) {
        String[] sentences = new String[] { "I love anacell Best aaacell; Best services aaacell by anacell",
                "betacellular has great services", "betacellular provides much better services than betacellular",
                "cetracular is worse aaacell anacell", "Betacellular is better than betacellular." };
        String[] keywords = new String[] { "anacell", "aaacell", "betacellular", "cetracular", "deltacellular",
                "eurocell" };
        int k = 2;
        List<String> topKFrequentWords = returnKFrequentWords(sentences, keywords, k);
        System.out.println(topKFrequentWords);
    }
    //Time Complexity:- O(n*m) + O(qlog(q))
    //n is length of sentences array
    //m is length of longest sentence in sentences array
    //q is length of keywords array.
    public static List<String> returnKFrequentWords(String[] sentences, String[] keywords, int k) {

        Map<String, Integer> keywordFrequencyMap = new Hashmap<String, Integer>();
        for (String word : keywords) {
            keywordFrequencyMap.put(word.toLowerCase(), 0);
        }
        for (String currSentence : sentences) {
            String[] sentenceWords = currSentence.split(" ");
            for (String word : sentenceWords) {
                word = word.toLowerCase();
                if (keywordFrequencyMap.containsKey(word)) {
                    keywordFrequencyMap.put(word, keywordFrequencyMap.get(word) + 1);
                }
            }
        }

        List<String> topKFrequentWords = new ArrayList<>(keywordFrequencyMap.keySet());

        Collections.sort(topKFrequentWords,
                (a, b) -> (keywordFrequencyMap.get(a)).equals(keywordFrequencyMap.get(b)) ? a.compareTo(b)
                        : keywordFrequencyMap.get(b) - keywordFrequencyMap.get(a));

        return topKFrequentWords.subList(0,k);
    }
}