import java.util.Arrays;
import java.util.Random;
public class MaximumSum {
    public static void main(String[] args) {
        int[] numArr=new int[100000];
        int[][] subArrIndex = new int[][] { {1,2},{1,5},{2,6},{6,6},{5,5},{5,5},{3,5} };// 1 based index
        Random rnd = new Random();
        for (int i = 0; i < 100000; i++) {
            numArr[i] = rnd.nextInt(100000);
        }
        System.out.println("Difference is " + maxSumDifference(numArr, subArrIndex));

    }

    public static long maxSumDifference(int[] numArr, int[][] subArrIndex) {
        
        long[] freq = new long[numArr.length];
        for (int[] sIndex : subArrIndex) {
            freq[sIndex[0] - 1] += 1;
            if (sIndex[1] < numArr.length) {
                freq[sIndex[1]] -= 1;
            }
        }

        for (int itr = 1; itr < numArr.length; itr++) {
            freq[itr] += freq[itr - 1];
        }


        // calculating subarr sum for alice
        long aliceSum = 0L;
        for(int itr=0;itr<numArr.length;itr++){
            aliceSum+=(freq[itr]*numArr[itr]);
        }
        System.out.println("Alice's sum is " + aliceSum);

        Arrays.sort(freq);
        Arrays.sort(numArr);
        long bobSum = 0L;
        for (int itr = numArr.length - 1; itr >= 0; itr--) {
            if (freq[itr] == 0) {
                break;
            }
            bobSum += (freq[itr] * numArr[itr]);
        }
        System.out.println("Bob Sum " + bobSum);
        return bobSum - aliceSum;
    }
}