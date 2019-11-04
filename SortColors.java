import java.io.*;
import java.util.Arrays;

class SortColors {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int colorsArr[] = new int[n];
        String tokens[] = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            colorsArr[i] = Integer.parseInt(tokens[i]);
        }
        System.out.println(Arrays.toString(colorsArr));
        int pivot = Integer.parseInt(br.readLine());
        sortColorsArr(colorsArr, pivot);
        System.out.println(Arrays.toString(colorsArr));
    }

    // sample input:- colorsArr=[2,0,2,0,1,1], pivot=1
    // output:- [0,0,1,1,2,2]
    public static void sortColorsArr(int[] colorsArr, int pivot) {
        // traversing with three pointers
        int l = 0, mid = 0, r = colorsArr.length - 1;
        while (mid <= r) {
            if (colorsArr[mid] < pivot) {
                // mid elem less than pivot than swap with left ptr
                int temp = colorsArr[mid];
                colorsArr[mid] = colorsArr[l];
                colorsArr[l] = temp;
                l++;
                mid++;
            } else if (colorsArr[mid] == pivot) {
                // mid elem equals pivot than continue
                mid++;
            } else {
                // mid elem gtr than pivot than swap with right ptr
                int temp = colorsArr[mid];
                colorsArr[mid] = colorsArr[r];
                colorsArr[r] = temp;
                r--;
            }
        }
    }
}