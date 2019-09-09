import java.io.*;

class TwoPairs {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String token[] = br.readLine().split(" ");
            int n = Integer.parseInt(token[0]);
            int sumElem = Integer.parseInt(token[1]);
            token = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(token[i]);
            }

            int pivot = 0;

            while (pivot < n - 1 && arr[pivot] < arr[pivot + 1]) {
                pivot++;
            }
            pivot++;

            int l = pivot, r = pivot - 1;
            while (l != r) {
                if (arr[l] + arr[r] == sumElem)
                    break;
                if (arr[l] + arr[r] < sumElem) {
                    if (l == n - 1)
                        l = 0;
                    else
                        l++;
                } else {
                    if (r == 0)
                        r = n - 1;
                    else
                        r--;
                }

            }
            if (l != r) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}