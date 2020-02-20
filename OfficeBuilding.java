import java.io.*;

class OfficeCordinates {
    int row = 0, col = 0;
}

class OfficeBuilding {

    //creates recursion tree for every posiible cell position.
    public static int returnMinDistancePlacement(int h, int w, OfficeCordinates[] OC, int currOCIndex) {
        if (currOCIndex == OC.length) {
            return calcMaxDistance(h, w, OC);
        }
        int minDistancePlacement = Integer.MAX_VALUE, startR = 0, startC = 0;

        if (currOCIndex != 0) {
            startR = OC[currOCIndex - 1].row;
            if (OC[currOCIndex - 1].col == w - 1) {
                startR = +1;
                startC = 0;
            } else {
                startC = OC[currOCIndex - 1].col + 1;
            }
        }

        for (int r = startR; r < h; r++) {
            for (int c = startC; c < w; c++) {
                OC[currOCIndex].row = r;
                OC[currOCIndex].col = c;
                int currMin = returnMinDistancePlacement(h, w, OC, currOCIndex + 1);
                minDistancePlacement = minDistancePlacement > currMin ? currMin : minDistancePlacement;
            }
        }
        return minDistancePlacement;
    };

    //Calculates distance of farthest cell from office cell
    //Time Complexity:- O(h*w*n)
    public static int calcMaxDistance(int h, int w, OfficeCordinates[] OC) {
        int maxDistance = Integer.MIN_VALUE;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                int currCellMinDist = Integer.MAX_VALUE;
                for (int oLoc = 0; oLoc < OC.length; oLoc++) {
                    int tempDist = Math.abs(r - OC[oLoc].row) + Math.abs(c - OC[oLoc].col);
                    currCellMinDist = currCellMinDist > tempDist ? tempDist : currCellMinDist;
                }
                maxDistance = maxDistance < currCellMinDist ? currCellMinDist : maxDistance;
            }
        }
        return maxDistance;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        //stores coordinates for every office cell
        OfficeCordinates[] OC = new OfficeCordinates[n];
        for (int i = 0; i < OC.length; i++) {
            OC[i] = new OfficeCordinates();
        }

        System.out.println("Minimum Distance Placement is " + returnMinDistancePlacement(h, w, OC, 0));
    }
}