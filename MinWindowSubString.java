import java.util.*;
import java.io.*;

public class MinWindowSubString {
    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // adding "t" string characters in hashmap
        HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            targetMap.put(currChar, targetMap.getOrDefault(currChar, 0) + 1);
        }
        // formedCharsMap for storing the count of desired chars in current window
        HashMap<Character, Integer> formedCharsMap = new HashMap<Character, Integer>();

        int requiredChars = targetMap.size(), formedChars = 0, windowStart = 0, windowEnd = 0;
        int[] ans = { Integer.MAX_VALUE, 0, 0 };
        while (windowEnd < s.length()) {
            char winEndChar = s.charAt(windowEnd);
            if (targetMap.containsKey(winEndChar)) {
                int charCount = formedCharsMap.getOrDefault(winEndChar, 0) + 1;
                formedCharsMap.put(winEndChar, charCount);

                if (charCount == targetMap.get(winEndChar))
                    formedChars++;
            }
            while (windowStart <= windowEnd && formedChars == requiredChars) {

                if (ans[0] > (windowEnd - windowStart + 1)) {
                    ans[0] = windowEnd - windowStart + 1;
                    ans[1] = windowStart;
                    ans[2] = windowEnd;
                }
                char winStartChar = s.charAt(windowStart);
                if (targetMap.containsKey(winStartChar)) {
                    formedCharsMap.put(winStartChar, formedCharsMap.get(winStartChar) - 1);
                    if (targetMap.get(winStartChar).intValue() > formedCharsMap.get(winStartChar).intValue()) {
                        formedChars--;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();
        System.out.println(minWindow(s, t));
    }
}