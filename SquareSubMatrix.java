class SquareSubMatrix {
    public static void main(String args[]) {
        boolean testArr[][] = { 
            { true, false, false },
            { true, false, false },
            { true, false, false } 
        };
        System.out.println("Max length:-" + findLargestSquare(testArr));
    }

    public static int findLargestSquare(boolean[][] sqArr) {
        int noOfRows = sqArr.length;
        if (noOfRows == 0)
            return 0;
        int noOfColumns = sqArr[0].length;
        if (noOfColumns == 0)
            return 0;
        int[][] cache = new int[noOfRows][noOfColumns];

        int max = Integer.MIN_VALUE;
        for (int rowNo = 0; rowNo < noOfRows; rowNo++) {
            for (int colNo = 0; colNo < noOfColumns; colNo++) {
                //iterating through matrix and if current cell is true,
                //it can be part of larger submatrix with true values
                if (sqArr[rowNo][colNo])
                    max = Math.max(max, findLargestSquare(sqArr, cache, rowNo, colNo));
            }
        }
        return max;
    }

    public static int findLargestSquare(boolean[][] sqArr, int[][] cache, int rowNo, int colNo) {
        //if recursive call is for out of boundary of row or column, iniated by any cell in last column or last row
        if (rowNo == sqArr.length || colNo == sqArr[0].length)
            return 0;

        //if current cell is false then it cannot be upper left cell of a square submatrix.
        if (!sqArr[rowNo][colNo])
            return 0;

        if(cache[rowNo][colNo]>0)
            return cache[rowNo][colNo];
        // recursively finding whether right, bottom and right-bottom are part of square submatrix.
        cache[rowNo][colNo]=1 + Math.min(
                Math.min(findLargestSquare(sqArr, cache, rowNo + 1, colNo),
                        findLargestSquare(sqArr, cache, rowNo, colNo + 1)),
                findLargestSquare(sqArr, cache, rowNo + 1, colNo + 1));
        return cache[rowNo][colNo];
    }
}