import java.io.*;

class Rotate {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int f = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String token[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(token[i]);

        for (int i = 0; i < f / 2; i++) {
            int temp = arr[f - i - 1];
            arr[f - i - 1] = arr[i];
            arr[i] = temp;
        }
        for (int i = f, j=0; i < ((n - f) / 2) + f; i++, j++) {
            int temp = arr[n - j - 1];
            arr[n - j - 1] = arr[i];
            arr[i] = temp;
        }
        
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[n - i - 1];
            arr[n - i - 1] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}