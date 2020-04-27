import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HPDP {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= t; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int a[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int cost[][] = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int kk = 0; kk < m; kk++) {
                    cost[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            long dp[][][] = compute(a, cost, n, k, m);

            long ans = Long.MAX_VALUE;

            for (int i = 0; i < m; i++) {

                if (dp[n - 1][k - 1][i] != -1) {
                    ans = Math.min(ans, dp[n - 1][k - 1][i]);
                }
            }

            if (ans == Long.MAX_VALUE)
                System.out.println("-1");
            else
                System.out.println(ans);

        }
    }

    private static long[][][] compute(int a[], int cost[][], int n, int k, int m) {

        long dp[][][] = new long[n][k][m];

        for (int apar = 0; apar < n; apar++) {
            boolean curr_apar_painted = a[apar] != 0;

            for (int score = 0; score < k; score++) {

                for (int paint = 0; paint < m; paint++) {

                    if (score > apar) {
                        dp[apar][score][paint] = -1L;
                        continue;
                    }
                    if (curr_apar_painted && (paint != a[apar] - 1)) {
                        dp[apar][score][paint] = -1L;
                        continue;
                    }
                    if (apar == 0) {
                        dp[apar][score][paint] = cost[apar][a[apar] = 1];
                    } else {
                        long val = Long.MAX_VALUE;
                        for (int prev_paint = 0; prev_paint < m; prev_paint++) {
                            if (prev_paint == paint) {
                                if (dp[apar - 1][score][prev_paint] != -1)
                                    val = Math.min(dp[apar - 1][score][prev_paint], val);
                            } else if (score > 0) {
                                if (dp[apar - 1][score - 1][prev_paint] != -1) {
                                    val = Math.min(dp[apar - 1][score - 1][prev_paint], val);
                                }
                            }
                            if (val != Long.MAX_VALUE) {
                                dp[apar][score][paint] = val;
                                if (!curr_apar_painted) {
                                    dp[apar][score][paint] += cost[apar][paint];
                                }
                            } else {
                                dp[apar][score][paint] = -1;
                            }
                        }
                    }
                }

            }
        }

        return dp;

    }
}
