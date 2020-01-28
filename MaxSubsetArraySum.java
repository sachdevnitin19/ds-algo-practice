/*
    Problem Statement:- given an array of integers find the maximum sum that can be produced 
                        by subset of given array under one condition i.e no two numbers in subset should contain 
                        same digit.

    Example:-   array=[12, 23, 5]
                max sum=28, {23,5} subset produces 28. 
                You cannot use {12,23} since they contain same digit i.e 2
    Time Complexity:- O(n) 
    Space Complexity:- O(2*n) => O(n)
    where n is length of input array
*/

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

class MaxSubsetArraySum {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tempArr = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(tempArr[i]);
        HashSet<Integer> digitSet = new HashSet<Integer>();
        int[][] memoizaton = new int[n][2];
        System.out.println("max subset sum is " + calcSubsetSum(arr, 0, digitSet, memoizaton));
    }

    public static int calcSubsetSum(int[] arr, int index, HashSet<Integer> digitSet, int[][] memoization) {
        if (index >= arr.length)
            return 0;

        ArrayList<Integer> digitsArr = convertNumToArr(arr[index]);
        int inclSum = memoization[index][0];

        if (inclSum == 0 && !doesNoDigitsExists(digitsArr, digitSet)) {
            addNoDigitToSet(digitsArr, digitSet);
            inclSum = arr[index] + calcSubsetSum(arr, index + 1, digitSet, memoization);
            removeNoDigitFromSet(digitsArr, digitSet);
            memoization[index][0] = inclSum;
        }

        int exclSum = memoization[index][1];
        if (exclSum == 0) {
            exclSum = calcSubsetSum(arr, index + 1, digitSet, memoization);
            memoization[index][1] = exclSum;
        }
        return Math.max(inclSum, exclSum);

    }

    public static ArrayList<Integer> convertNumToArr(int num) {
        ArrayList<Integer> digitsArr = new ArrayList<Integer>();
        while (num > 0) {
            digitsArr.add(num % 10);
            num = num / 10;
        }
        return digitsArr;
    }

    public static boolean doesNoDigitsExists(ArrayList<Integer> digitsArr, HashSet<Integer> digitSet) {
        Iterator<Integer> digitsItr = digitsArr.iterator();
        while (digitsItr.hasNext()) {
            if (digitSet.contains(digitsItr.next()))
                return true;
        }
        return false;
    }

    public static void addNoDigitToSet(ArrayList<Integer> digitsArr, HashSet<Integer> digitSet) {
        Iterator<Integer> digitsItr = digitsArr.iterator();
        while (digitsItr.hasNext()) {
            digitSet.add(digitsItr.next());
        }
    }

    public static void removeNoDigitFromSet(ArrayList<Integer> digitsArr, HashSet<Integer> digitSet) {
        Iterator<Integer> digitsItr = digitsArr.iterator();
        while (digitsItr.hasNext()) {
            digitSet.remove(digitsItr.next());
        }
    }

}