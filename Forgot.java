import java.io.*;
import java.util.StringTokenizer;

class Forgot {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int dictWords = Integer.parseInt(st.nextToken());
            int phrases = Integer.parseInt(st.nextToken());
            String dict[] = new String[dictWords];
            boolean isDictUsed[] = new boolean[dictWords];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < dictWords; i++) {
                dict[i] = st.nextToken();
            }
            for (int i = 0; i < phrases; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int phraseLength = Integer.parseInt(st.nextToken());
                for (int j = 0; j < phraseLength; j++) {
                    String currString = st.nextToken();
                    for (int k = 0; k < dictWords; k++) {
                        if (dict[k].matches(currString)) {
                            isDictUsed[k] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < dictWords; i++) {
                if (i < dictWords - 1)
                    System.out.print(isDictUsed[i] ? "YES " : "NO ");
                else
                    System.out.print(isDictUsed[i] ? "YES" : "NO");
            }
            if (t != 0)
                System.out.println("");
        }
    }
}