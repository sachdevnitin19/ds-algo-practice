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
            int finalPar[] = new int[parLength];

            for (int i = 0; i < parLength; i++)
                initialPar[i] = Integer.parseInt(temp[i]);
            int j = 0;
            for (int i = 0; i < parLength; i++) {
                if (i == parLength - 1) {
                    while (lane.peek() != -1 && lane.peek() < initialPar[i]) {
                        finalPar[j++] = lane.pop();
                    }
                    finalPar[j++] = initialPar[i];
                    break;
                }
                if (initialPar[i] > initialPar[i + 1]) {
                    lane.push(initialPar[i]);
                } else if (initialPar[i] < initialPar[i + 1] && (!lane.isStackEmpty() && lane.peek() < initialPar[i])) {
                    while (lane.peek() != -1 && lane.peek() < initialPar[i]) {
                        finalPar[j++] = lane.pop();
                    }
                    finalPar[j++] = initialPar[i];
                } else {
                    finalPar[j++] = initialPar[i];
                }
            }
            lane.printStack();
            if (!lane.isStackEmpty()) {
                while (!lane.isStackEmpty()) {
                    finalPar[j++] = lane.pop();
                }
            }
            for (int i = 0; i < parLength; i++)
                System.out.print(finalPar[i] + " ");
            parLength = Integer.parseInt(br.readLine());
        }
    }
}
