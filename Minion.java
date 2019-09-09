import java.io.*;
import java.util.StringTokenizer;

class Minion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                if ((Integer.parseInt(st.nextToken()) + k) % 7 == 0) {
                    count++;
                }
            }
            System.out.println(count);

            t--;
        }
    }
}