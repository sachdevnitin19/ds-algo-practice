import java.io.*;
import java.util.Arrays;

class ChildHopping {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfSteps = Integer.parseInt(br.readLine());
        long cache[] = new long[noOfSteps+1];
        Arrays.fill(cache, -1);
        System.out.println("Total no of possible ways for reaching top:-");
        System.out.println(noOfPossibleWays(noOfSteps, cache));
    }

    public static long noOfPossibleWays(int noOfSteps, long[] cache) {
        if (noOfSteps < 0) {
            return 0;
        } else if (noOfSteps == 0) {
            return 1;
        } else if (cache[noOfSteps] != -1) {
            return cache[noOfSteps];
        } else {
            cache[noOfSteps] = noOfPossibleWays(noOfSteps - 1, cache) + noOfPossibleWays(noOfSteps - 2, cache)
                    + noOfPossibleWays(noOfSteps - 3, cache);
            return cache[noOfSteps];
        }
    }
}