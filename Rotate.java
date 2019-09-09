import java.io.*;

class Rotate {
    static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String token[] = br.readLine().split(" ");
            int n = Integer.parseInt(token[0]);
            int f = Integer.parseInt(token[1]);
            int arr[] = new int[n];
            token = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(token[i]);

            reverseArr(arr, 0, f-1);
            reverseArr(arr, f, n-1);
            reverseArr(arr, 0, n-1);
            
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}