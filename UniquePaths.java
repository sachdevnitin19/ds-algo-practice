import java.io.*;

class UniquePaths {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // System.out.println("Total unique paths= " + calculateUniquePath(m, n));
        System.out.println("Total unique paths= " + calculateUniquePathsV2(m, n));
    }

    //Top down approach with Time and Space Complexity O(m*n)
    public static int calculateUniquePath(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        return calculateUniquePath(m, n, cache);
    }

    public static int calculateUniquePath(int m, int n, int[][] cache) {
        if (n == 1 || m == 1) {
            return 1;
        }
        if (cache[m][n] > 0)
            return cache[m][n];
        cache[m][n] = calculateUniquePath(m - 1, n, cache) + calculateUniquePath(m, n - 1, cache);
        return cache[m][n];
    }

    //Bottom Up Approach with Time Complexity O(m*n) and Space Complexity O(min(m.n))

    public static int calculateUniquePathsV2(int m, int n) {
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }
        
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cache[j]=cache[j]+cache[j-1];
            }
        }
        return cache[n-1];
    }
}