import java.io.*;
import java.util.*;

class RearrangeArr2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String tokens[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(tokens[i]);

            int tempArr[] = new int[n];
            for (int i = 0; i < n; i++)
                tempArr[i] = arr[i];
            Arrays.sort(tempArr);
            int oddPos=n-(n/2);
            int j = oddPos - 1;
            for (int i = 0; i < n; i += 2) {
                arr[i] = tempArr[j];
                j--;
            }

            j = oddPos;
            for (int i = 1; i < n; i += 2) {
                arr[i] = tempArr[j];
                j++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");
            System.out.println(sb);
        }
    }
}