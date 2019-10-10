import java.io.*;
import java.util.*;

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
        System.out.println(findTriplets(arr, searchNum));
    }

    public static List<List<Integer>> findTriplets(int[] arr, int searchNum) {
        if(arr.length<3){
            return Collections.emptyList();
        }
        Arrays.sort(arr);
        Set<List<Integer>> triplicates = new HashSet<List<Integer>>();
        for (int i = 0; i < arr.length - 1; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                int lrSum = arr[l] + arr[r];
                if (arr[i] + lrSum == searchNum) {
                    triplicates.add(Arrays.asList(arr[i], arr[l++], arr[r--]));
                } else if (arr[i] + lrSum > searchNum) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new ArrayList<>(triplicates);
    }
}