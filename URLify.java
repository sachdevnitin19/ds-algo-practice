import java.io.*;

class URLify {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int actualLen = Integer.parseInt(br.readLine());
        System.out.println(urlifyString(str, actualLen));
    }

    public static String urlifyString(String str, int actualLen) {
        char[] strArr = str.toCharArray();
        int index = str.length() - 1;
        for (int i = actualLen - 1; i >= 0; i--) {
            if (strArr[i] == ' ') {
                strArr[index] = '0';
                strArr[index - 1] = '2';
                strArr[index - 2] = '%';
                index -= 3;
            } else {
                strArr[index] = strArr[i];
                index--;
            }
        }
        return new String(strArr);
    }
}