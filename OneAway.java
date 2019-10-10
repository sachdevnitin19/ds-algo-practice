import java.io.*;

class OneAway {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        // if (checkOneAway(str1, str2)) {
        // System.out.println("Strings are zero or one edit away");
        // } else {
        // System.out.println("Strings are more than one edit away");
        // }

        if (oneAwayV2(str1, str2)) {
            System.out.println("Strings are zero or one edit away");
        } else {
            System.out.println("Strings are more than one edit away");
        }
    }

    public static boolean checkOneAway(String str1, String str2) {
        int charArray[] = new int[26];
        int str1Len = str1.length(), str2Len = str2.length();
        if (Math.abs(str1Len - str2Len) > 1) {
            return false;
        }
        for (int i = 0; i < str1Len; i++) {
            int charIndex = (int) str1.charAt(i) - 97;
            charArray[charIndex]++;
        }

        for (int i = 0; i < str2Len; i++) {
            int charIndex = (int) str2.charAt(i) - 97;
            charArray[charIndex]--;
        }
        int diffCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 0) {
                diffCount++;
            }
        }
        System.out.println(diffCount);
        return diffCount > 2 ? false : true;
    }

    public static boolean oneAwayV2(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        String s1, s2;
        if (str1.length() < str2.length()) {
            s1 = str1;
            s2 = str2;
        } else {
            s1 = str2;
            s2 = str1;
        }
        int str1Len = s1.length(), str2Len = s2.length(), index1 = 0, index2 = 0;
        boolean foundFlag = false;
        while (index2 < str2Len && index1 < str1Len) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundFlag) {
                    return false;
                }
                foundFlag = true;
                if (str1Len == str2Len) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;

    }
}