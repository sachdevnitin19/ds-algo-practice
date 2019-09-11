import java.io.*;
import java.util.*;

class ANAGRAM {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words[] = br.readLine().split(" ");
        List<List<String>> groupOfAnagrams = groupAnagrams(words);
        Iterator<List<String>> outerItr = groupOfAnagrams.iterator();
        while (outerItr.hasNext()) {
            List<String> innerList = (List<String>) outerItr.next();
            Iterator<String> innerItr = innerList.iterator();
            while (innerItr.hasNext()) {
                System.out.print(innerItr.next() + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupOfAnagrams = new ArrayList<List<String>>();
        HashMap<String, Integer> anagramIndexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String stringCode = getStringCode(strs[i]);
            if (anagramIndexMap.containsKey(stringCode)) {
                int anagramIndex = anagramIndexMap.get(stringCode);
                List<String> anagramGroup = groupOfAnagrams.get(anagramIndex);
                anagramGroup.add(strs[i]);
            } else {
                int anagramIndex = groupOfAnagrams.size();
                anagramIndexMap.put(stringCode, anagramIndex);
                List<String> anagramGroup = new ArrayList<String>();
                anagramGroup.add(strs[i]);
                groupOfAnagrams.add(anagramGroup);
            }
        }
        return groupOfAnagrams;
    }

    public static String getStringCode(String word) {
        int[] charCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int asciiCode = word.charAt(i);
            charCount[asciiCode - 97] += 1;
        }
        String stringCode = "";
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0)
                continue;
            stringCode += ("" + (i + 97) + charCount[i]);
        }
        return stringCode;
    }
}