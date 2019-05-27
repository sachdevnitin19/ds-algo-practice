import java.io.*;

class Cops {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] temp=br.readLine().split(" ");
            int totalCopsHouses = Integer.parseInt(temp[0]);
            int copsSpeed = Integer.parseInt(temp[1]);
            int copsSearchTime = Integer.parseInt(temp[2]);

            int factor = copsSpeed * copsSearchTime;
            temp=br.readLine().split(" ");
            int copshouses[] = new int[totalCopsHouses];
            for (int i = 0; i < totalCopsHouses; i++)
                copshouses[i] = Integer.parseInt(temp[i]);
            boolean housesCovered[] = new boolean[100];

            for (int i = 0; i < totalCopsHouses; i++) {
                int l = copshouses[i] - factor-1;
                int r = copshouses[i] + factor;
                if (l < 0)
                    l = 0;
                if (r > 100)
                    r = 100;
                for (int j = l; j < r; j++) {
                    housesCovered[j] = true;
                }
            }
            int totalHousesSafe = 0;
            for (int i = 0; i < 100; i++) {
                if (!housesCovered[i])
                    totalHousesSafe++;
            }
            System.out.println(totalHousesSafe);
        }
    }
}