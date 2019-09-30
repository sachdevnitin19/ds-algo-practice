import com.nitin.utils.Sorting;

class SortSquaredArray {
    public static int[] sortSquaredArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Sorting.MergeSort(A, 0, A.length-1);
        // Sorting.QuickSort(A, 0, A.length - 1);
        return A;
    }

    public static void main(String args[]) {
        int A[] = { -9, -8, -2, 2, 3, 4, 6 };
        A = sortSquaredArray(A);
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}