import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        // int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int k = 3;
        int[] nums = new int[] { -95, 92, -85, 59, -59, -14, 88, -39, 2, 92, 94, 79, 78, -58, 37, 48, 63, -91, 91, 74,
                -28, 39, 90, -9, -72, -88, -72, 93, 38, 14, -83, -2, 21, 4, -75, -65, 3, 63, 100, 59, -48, 43, 35, -49,
                48, -36, -64, -13, -7, -29, 87, 34, 56, -39, -5, -27, -28, 10, -57, 100, -43, -98, 19, -59, 78, -28,
                -91, 67, 41, -64, 76, 5, -58, -89, 83, 26, -7, -82, -32, -76, 86, 52, -6, 84, 20, 51, -86, 26, 46, 35,
                -23, 30, -51, 54, 19, 30, 27, 80, 45, 22 };
        int k = 10;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // edge case
        if (nums.length == 0) {
            return new int[0];
        }
        // if window size is 1 then return original array
        if (k == 1) {
            return nums;
        }
        // to store max elem in current window
        int[] maxElemInSlidingWindow = new int[nums.length - k + 1];
        maxElemInSlidingWindow[0] = Integer.MIN_VALUE;

        // using deque to store consecutive nums in descending order in current window
        Deque<Integer> currMax = new LinkedList<>();
        // doing pre processing for first k elements
        for (int itr = 0; itr < k; itr++) {
            if (nums[itr] > maxElemInSlidingWindow[0]) {
                maxElemInSlidingWindow[0] = nums[itr];
                currMax.clear();
                currMax.add(nums[itr]);
            } else if (currMax.size() == 1) {
                currMax.add(nums[itr]);
            } else if (nums[itr] > currMax.peekLast()) {
                currMax.removeLast();
                currMax.add(nums[itr]);
            }
        }
        // if array length is equal to window length
        if (nums.length == k) {
            return new int[] { maxElemInSlidingWindow[0] };
        }

        // sliding the window and executing one of the following:-
        // 1. if new element entered in window > elem at head of DQ, then clearing DQ
        // and adding new elem
        // 2. else if DQ size is 1 then adding new elem
        // 3. else until we find correct position for new elem in our DQ we keep on
        // removing from tail and finally adding it.
        // since we need to maintain DQ in desc order.
        // also we check that is the elem at end of window i.e left side is current max
        // we remove it from DQ before next iteration
        int windowSlow = 0, windowFast = k - 1, itr = 0;
        while (windowFast < nums.length) {
            if (nums[windowFast] > currMax.peekFirst()) {
                currMax.clear();
                currMax.add(nums[windowFast]);
            } else if (currMax.size() == 1) {
                currMax.add(nums[windowFast]);
            } else {
                while (currMax.peekLast() < nums[windowFast]) {
                    currMax.removeLast();
                }
                currMax.add(nums[windowFast]);
            }

            maxElemInSlidingWindow[itr] = currMax.peekFirst();
            if (nums[windowSlow] == currMax.peekFirst()) {
                currMax.removeFirst();
            }
            itr++;
            windowFast++;
            windowSlow++;
        }

        return maxElemInSlidingWindow;
    }

}