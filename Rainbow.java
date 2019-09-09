import java.io.*;
import java.util.StringTokenizer;

class Rainbow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            int arr[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
            boolean flag = true;
            if (arr[n / 2] != 7 || arr[0] != 1) {
                flag = false;
            }

            for (int i = 0; i < n / 2; i++) {
                if (arr[i + 1] - arr[i] <= 1 && arr[i + 1] >= arr[i]) {
                    if (arr[i] != arr[n - i - 1]) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }


            }
            System.out.println(flag ? "yes" : "no");


            t--;
        }
    }
}