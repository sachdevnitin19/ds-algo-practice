import java.io.*;
import java.util.StringTokenizer;

class LeCandy {
    public static void main(String[] args) throws IOException {

        int t = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sum = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            if (sum <= c) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            t--;
        }
    }
}