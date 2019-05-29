import java.io.*;

class JNEXT {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int strLength = Integer.parseInt(br.readLine());
            int strArr[] = new int[strLength];
            String token[] = br.readLine().split(" ");
            for (int k = 0; k < strLength; k++)
                strArr[k] = Integer.parseInt(token[k]);

            // boolean permutFound = false;
            int i = strLength - 1, j = strLength - 1;
            while (i-- > 0) {
                if (strArr[i] > strArr[i - 1])
                    break;
            }
            if (i > 0) {
                while (j-- > 0) {
                    if (strArr[j] > strArr[i - 1])
                        break;
                }

                int temp = strArr[i - 1];
                strArr[i - 1] = strArr[j];
                strArr[j] = temp;
                j = strLength - 1;

                while (i < j) {
                    temp = strArr[j];
                    strArr[j] = strArr[i];
                    strArr[i] = temp;
                    i++;
                    j--;
                }
                for (int k = 0; k < strLength; k++)
                    System.out.print(strArr[k] + " ");
                System.out.println();
            } else {
                System.out.println(0);
            }

        }
    }
}