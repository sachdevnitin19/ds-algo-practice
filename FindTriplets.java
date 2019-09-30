import java.io.*;
import java.util.Arrays;

class FindTriplets {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        int searchNum = Integer.parseInt(br.readLine());
        findTriplets(arr, searchNum);
    }

    public static void findTriplets(int[] arr, int searchNum) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            boolean found = false;
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                int lrSum = arr[l] + arr[r];
                if (arr[i] + lrSum == searchNum) {
                    found = true;
                    break;
                } else if (arr[i] + lrSum > searchNum) {
                    r--;
                } else {
                    l++;
                }
            }
            if (found) {
                System.out.printf("Triplets:- %d %d %d", arr[i], arr[l], arr[r]);
                System.out.println();
                return;
            }
        }
        System.out.println("No Triplets found");
        return;
    }
}