class SquareSubMatrix {
    public static void main(String args[]) {
        boolean testArr[][]={
            {true,true,false},
            {true,true,false},
            {true,true,false}
        };
        System.out.println("Max length:-"+findLargestSquare(testArr));
    }

    public static int findLargestSquare(boolean[][] sqArr) {
        int noOfRows = sqArr.length;
        if (noOfRows == 0)
            return 0;
        int noOfColumns = sqArr[0].length;
        if (noOfColumns == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                //computing for each cell
                if (sqArr[i][j])
                    max = Math.max(max, findLargestSquare(sqArr, i, j));
            }
        }
        return max;
    }

    public static int findLargestSquare(boolean[][] sqArr, int i, int j) {
        //if current cell is in last row or column then it cannot be upper left cell of square submatrix.
        if (i == sqArr.length || j == sqArr[0].length)
            return 0;
        
        //if current cell is false then it cannot be upper left cell of a square submatrix.
        if (!sqArr[i][j])
            return 0;
        
        // recursively finding whether right, bottom and right-bottom are part of square submatrix.
        return 1+Math.min(Math.min(findLargestSquare(sqArr, i+1, j),findLargestSquare(sqArr, i, j+1)),findLargestSquare(sqArr, i+1, j+1));
    }
}