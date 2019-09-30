package com.nitin.utils;

public class Sorting {
    public static void MergeSort(int[] A, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            MergeSort(A, l, m);
            MergeSort(A, m + 1, r);

            MergeTwoArray(A, l, m, r);
        }
    }

    private static void MergeTwoArray(int A[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int temp1[] = new int[n1];
        int temp2[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            temp1[i] = A[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            temp2[j] = A[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (temp1[i] < temp2[j]) {
                A[k] = temp1[i];
                i++;
            } else {
                A[k] = temp2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            A[k] = temp1[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = temp2[j];
            j++;
            k++;
        }
    }

    public static void QuickSort(int A[], int l, int r) {
        if (l < r) {
            int pi = partition(A, l, r);
            QuickSort(A, l, pi - 1);
            QuickSort(A, pi + 1, r);
        }
    }

    private static int partition(int[] A, int l, int r) {
        int i = l - 1, j = 0, temp;
        for (j = l; j < r; j++) {
            if (A[j] < A[r]) {
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return (i + 1);
    }
}