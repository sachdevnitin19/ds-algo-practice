import java.util.StringTokenizer;
import java.io.*;

class CNote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int pagesRequired = x - y;
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (p >= pagesRequired && c <= k) {
                    flag = true;
                }
            }

            System.out.println(flag ? "LuckyChef" : "UnluckyChef");
            t--;
        }
    }
}