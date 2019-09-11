import java.io.*;

class RotateAndDelete {
    static void rotateArr(int[] arr, int n) {
        int elemCopy = arr[0], i = 0;
        while (i < n - 1 && arr[i] != 0) {
            arr[i] = arr[i+1];
            i++;
        }
        arr[i] = elemCopy;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String token[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(token[i]);
            
            // rotateArr(arr, n);
            // arr[n-1]=0;
            for (int i = 0; i < n-1; i++) {
                rotateArr(arr, n);
                arr[n-i+1]=0;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}