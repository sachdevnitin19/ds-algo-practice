import java.io.*;
import com.nitin.utils.GenericArrayStack;

class STPAR {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int parLength = Integer.parseInt(br.readLine());
        while (parLength != 0) {
            GenericArrayStack<Integer> lane = new GenericArrayStack<Integer>(parLength);
            String temp[] = br.readLine().split(" ");
            int initialPar[] = new int[parLength];
            int need = 1;
            boolean state = true;

            for (int i = 0; i < parLength; i++)
                initialPar[i] = Integer.parseInt(temp[i]);

            for (int i = 0; i < parLength; i++) {
                while (!lane.isStackEmpty() && lane.peek() == need) {
                    need++;
                }
                if (initialPar[i] == need) {
                    need++;
                } else if (!lane.isStackEmpty() && lane.peek() < initialPar[i]) {
                    state = false;
                    break;
                } else {
                    lane.push(initialPar[i]);
                }
            }

            System.out.println(state ? "yes" : "no");
            parLength = Integer.parseInt(br.readLine());
        }
    }
}
