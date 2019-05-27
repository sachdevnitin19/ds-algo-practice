import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

class Cops {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int totalCopsHouses = Integer.parseInt(st.nextToken());
            int copsSpeed = Integer.parseInt(st.nextToken());
            int copsSearchTime = Integer.parseInt(st.nextToken());
            int factor = copsSpeed * copsSearchTime;
            st = new StringTokenizer(br.readLine(), " ");
            int copsHouses[] = new int[totalCopsHouses];
            for (int i = 0; i < totalCopsHouses; i++)
                copsHouses[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(copsHouses);
            int l = 0, h = 1000, newl, newh, totalHousesSafe = 0;
            for (int i = 0; i < totalCopsHouses; i++) {
                newl = (copsHouses[i] - factor) >= 1 ? (copsHouses[i] - factor) : 1;
                newh = (copsHouses[i] + factor) <= 100 ? (copsHouses[i] + factor) : 100;
                if (l != 1) {
                    if (newl < l)
                        totalHousesSafe += (l - newl);
                    l = newl;
                }
                if (h != 100) {

                    if (newh > h && newl > h) {
                        totalHousesSafe += (newl - h - 1);
                    }

                    h = newh;
                }
            }
            if (l != 1) {
                totalHousesSafe += (l - 1);
            }
            if (h != 100) {
                totalHousesSafe += (100 - h);
            }
            System.out.println(totalHousesSafe);
        }
    }
}