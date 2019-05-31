import java.io.*;

class Stack {
    static final int MAX = 1000000;
    int top;
    int stackArr[] = new int[MAX];

    Stack() {
        top = -1;
    }

    boolean isStackFull() {
        return top >= MAX - 1;
    }

    boolean isStackEmpty() {
        return top < 0;
    }

    int peek() {
        if (top < 0)
            return -1;
        return stackArr[top];
    }

    boolean push(int x) {
        if (top >= MAX - 1) {
            System.out.println("stack full");
            return false;
        } else {
            stackArr[++top] = x;
            return true;
        }
    }

    int stackLength() {
        return top < 0 ? 0 : top + 1;
    }

    int pop() {
        if (top < 0)
            return -1;
        int x = stackArr[top--];
        return x;
    }

    void printStack() {
        int topCopy = top;
        System.out.println();
        while (topCopy >= 0) {
            System.out.print(stackArr[topCopy] + " ");
            topCopy--;
        }
        System.out.println();
    }
}

class STPAR {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int parLength = Integer.parseInt(br.readLine());
        while (parLength != 0) {
            Stack lane = new Stack();

            String temp[] = br.readLine().split(" ");
            int initialPar[] = new int[parLength];
            int need = 1;
            boolean state = true;

            for (int i = 0; i < parLength; i++)
                initialPar[i] = Integer.parseInt(temp[i]);
            int j = 0;
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
