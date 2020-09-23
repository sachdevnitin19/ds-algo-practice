import java.util.Arrays;

public class Tribonacci {

    static long[][] stepsCache;
    static long[] fibValues;
    static final long MODULUS = 1000000007;

    public static void main(String[] args) {

        int totalSteps = 3, threeStepMovesLeft = 0;
        stepsCache = new long[totalSteps + 1][threeStepMovesLeft + 1];
        fibValues = new long[500001];
        fibValues[0] = 0;
        fibValues[1] = 1;
        for (int i = 2; i < fibValues.length; i++) {
            fibValues[i] = fibValues[i - 1] + fibValues[i - 2];
        }
        stepsCache = new long[totalSteps + 1][threeStepMovesLeft + 1];
        for (long[] row : stepsCache) {
            Arrays.fill(row, -1);
        }
        System.out.println(calcWaysToClimb(totalSteps, threeStepMovesLeft));
    }

    public static long calcWaysToClimb(int totalSteps, int threeStepMovesLeft) {
        if (totalSteps < 0)
            return 0;
        if (totalSteps == 0)
            return 1;

        if (stepsCache[totalSteps][threeStepMovesLeft] > -1)
            return stepsCache[totalSteps][threeStepMovesLeft];

        long totalWays = 0L;

        totalWays = (totalWays + fibValues[totalSteps]) % MODULUS;
        
        if (threeStepMovesLeft > 0) {
            totalWays = (totalWays + calcWaysToClimb(totalSteps - 3, threeStepMovesLeft - 1)) % MODULUS;
        }
        stepsCache[totalSteps][threeStepMovesLeft] = totalWays;
        return totalWays;
    }
}