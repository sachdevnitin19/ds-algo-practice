import java.util.StringTokenizer;
import java.io.*;

class HPDP {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int noOfBuildings = Integer.parseInt(st.nextToken());
            int noOfPaints = Integer.parseInt(st.nextToken());
            int splOfLoc = Integer.parseInt(st.nextToken());

            int buildingPaint[] = new int[noOfBuildings];
            st = new StringTokenizer(br.readLine());
            for (int building = 0; building < noOfBuildings; building++) {
                buildingPaint[building] = Integer.parseInt(st.nextToken());
            }

            int buildingPaintCost[][] = new int[noOfBuildings][noOfPaints];
            for (int row = 0; row < noOfBuildings; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < noOfPaints; col++) {
                    buildingPaintCost[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(minCostToPaint(buildingPaint, buildingPaintCost, noOfBuildings, noOfPaints, splOfLoc));
        }
    }

    private static long minCostToPaint(int buildingPaint[], int buildingPaintCost[][], int noOfBuildings,
            int noOfPaints, int splOfLoc) {

        long memoization[][][] = new long[noOfBuildings][splOfLoc][noOfPaints];

        for (int apar = 0; apar < noOfBuildings; apar++) {
            boolean isCurrAptPainted = buildingPaint[apar] != 0;

            for (int score = 0; score < splOfLoc; score++) {

                for (int paint = 0; paint < noOfPaints; paint++) {

                    if (score > apar) {
                        memoization[apar][score][paint] = -1L;
                        continue;
                    }
                    if (isCurrAptPainted && (paint != buildingPaint[apar] - 1)) {
                        memoization[apar][score][paint] = -1L;
                        continue;
                    }
                    if (apar == 0) {
                        if (!isCurrAptPainted) {
                            memoization[apar][score][paint] = buildingPaintCost[apar][paint];
                        }

                    } else {
                        long val = Long.MAX_VALUE;
                        for (int prev_paint = 0; prev_paint < noOfPaints; prev_paint++) {
                            if (prev_paint == paint) {
                                if (memoization[apar - 1][score][prev_paint] != -1)
                                    val = Math.min(memoization[apar - 1][score][prev_paint], val);
                            } else if (score > 0) {
                                if (memoization[apar - 1][score - 1][prev_paint] != -1) {
                                    val = Math.min(memoization[apar - 1][score - 1][prev_paint], val);
                                }
                            }
                            if (val != Long.MAX_VALUE) {
                                memoization[apar][score][paint] = val;
                                if (!isCurrAptPainted) {
                                    memoization[apar][score][paint] += buildingPaintCost[apar][paint];
                                }
                            } else {
                                memoization[apar][score][paint] = -1;
                            }
                        }
                    }
                }

            }
        }

        long ans = Long.MAX_VALUE;

        for (int paint = 0; paint < noOfPaints; paint++) {

            if (memoization[noOfBuildings - 1][splOfLoc - 1][paint] != -1) {
                ans = Math.min(ans, memoization[noOfBuildings - 1][splOfLoc - 1][paint]);
            }
        }

        if (ans == Long.MAX_VALUE)
            return -1L;
        else
            return ans;

    }

}