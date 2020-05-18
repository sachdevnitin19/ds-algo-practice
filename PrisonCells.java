import java.util.Arrays;

class PrisonCells {
    public static void main(String[] args) {
        Solution soln = new Solution();
        int N = 3;
        int cells[] = new int[] { 0, 1, 0, 1, 1, 0, 0, 1 };
        System.out.println(Arrays.toString(soln.prisonAfterNDays(cells, N)));
    }

    static class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            while (N-- > 0) {
                int prevCellState = 0, itr = 0;
                while (itr < cells.length - 1) {
                    // for (int itr = 0; itr < cells.length-1; itr++) {
                    if (prevCellState == cells[itr + 1]) {
                        prevCellState = cells[itr];
                        cells[itr] = 1;
                    } else {
                        prevCellState = cells[itr];
                        cells[itr] = 0;
                    }
                    itr++;
                }
                if (prevCellState == 0) {
                    cells[itr] = 1;
                } else {
                    cells[itr] = 0;
                }
            }
            return cells;
        }
    }

}
