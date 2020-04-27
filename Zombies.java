import java.util.Queue;
import java.util.LinkedList;

public class Zombies {
    public static void main(String args[]) {
        int[][] grid=new int[][]{
            {0,1,1,0,1},
            {0,1,0,1,0},
            {0,0,0,0,1},
            {0,1,0,0,0}
        };
        System.out.println("Total hours to convert all cells to zombie:- "+minHoursToInfect(grid));
    }

    static int gridRows, gridCols;

    static class GridCell {
        int row, col;

        public GridCell(int r, int c) {
            this.row = r;
            this.col = c;
        }

        public String toString(){
            return "row= "+this.row+" col="+this.col;
        }
    }

    public static int minHoursToInfect(int[][] grid) {
        gridRows = grid.length;
        gridCols = grid[0].length;
        Queue<GridCell> infectedCellQ=new LinkedList<>();

        for(int rowItr=0;rowItr<gridRows;rowItr++){
            for(int colItr=0; colItr<gridCols; colItr++){
                if(grid[rowItr][colItr]==1)
                    infectedCellQ.add(new GridCell(rowItr, colItr));
            }
        }
        infectedCellQ.add(new GridCell(-1, -1));
        int hoursPassed=-1;
        while(!infectedCellQ.isEmpty()){

            while(infectedCellQ.peek().row!=-1){
                GridCell currCellToProcess=infectedCellQ.remove();

                //converting left cell to zombie
                if(isValidCell(currCellToProcess.row,currCellToProcess.col-1) && 
                grid[currCellToProcess.row][currCellToProcess.col-1]==0){
                    grid[currCellToProcess.row][currCellToProcess.col-1]=1;
                    infectedCellQ.add(new GridCell(currCellToProcess.row, currCellToProcess.col-1));
                }

                //converting top cell to zombie
                if(isValidCell(currCellToProcess.row-1,currCellToProcess.col) && 
                grid[currCellToProcess.row-1][currCellToProcess.col]==0){
                    grid[currCellToProcess.row-1][currCellToProcess.col]=1;
                    infectedCellQ.add(new GridCell(currCellToProcess.row-1, currCellToProcess.col));
                }

                //converting right cell to zombie
                if(isValidCell(currCellToProcess.row,currCellToProcess.col+1) && 
                grid[currCellToProcess.row][currCellToProcess.col+1]==0){
                    grid[currCellToProcess.row][currCellToProcess.col+1]=1;
                    infectedCellQ.add(new GridCell(currCellToProcess.row, currCellToProcess.col+1));
                }

                //converting bottom cell to zombie
                if(isValidCell(currCellToProcess.row+1,currCellToProcess.col) && 
                grid[currCellToProcess.row+1][currCellToProcess.col]==0){
                    grid[currCellToProcess.row+1][currCellToProcess.col]=1;
                    infectedCellQ.add(new GridCell(currCellToProcess.row+1, currCellToProcess.col));
                }
            }
            hoursPassed++;
            infectedCellQ.remove();
            if(!infectedCellQ.isEmpty()){
                infectedCellQ.add(new GridCell(-1, -1));
            }
            

        }
        return hoursPassed;
    }

    public static boolean isValidCell(int row, int col) {
        if (row >= 0 && row < gridRows && col >= 0 && col < gridCols) {
            return true;
        }
        return false;
    }

}