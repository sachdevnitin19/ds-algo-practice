import java.io.*;

class SearchInRotatedArray {
    static int binarySearch(int arr[], int start, int end, int searchElem) {
        while (start <= end) {
            int key = (end - start) / 2 + start;
            if (arr[key] == searchElem) {
                return key;
            } else if (arr[key] < searchElem) {
                start = key + 1;
            } else {
                end = key - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String token[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(token[i]);
            }
            int elem = Integer.parseInt(br.readLine());

            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            
            if (arr[l] == elem) {
                System.out.println(l);
            }
            l = elem < arr[0] ? l : 0;
            r = elem > arr[arr.length - 1] ? r - 1 : arr.length - 1;
            System.out.println(binarySearch(arr, l, r, elem));

        }
    }
}