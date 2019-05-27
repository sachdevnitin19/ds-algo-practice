import java.io.*;

class Stack {
    static final int MAX = 1000000;
    int top;
    char stackArr[] = new char[MAX];

    Stack() {
        top = -1;
    }

    boolean isStackFull() {
        return top >= MAX - 1;
    }

    boolean isStackEmpty() {
        return top < 0;
    }

    char peek() {
        return stackArr[top];
    }

    boolean push(char x) {
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

    char pop() {
        char x = stackArr[top--];
        return x;
    }
}

class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Stack st = new Stack();
            String str = br.readLine();
            char ch;
            int validStrLength = 0, actualStrLength = 0;

            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if ((!st.isStackEmpty() && st.peek() == '<' )&& ch == '>') {
                    validStrLength += 2;
                    st.pop();
                } else {
                    st.push(ch);
                }
                if (st.isStackEmpty()) {
                    actualStrLength = validStrLength;
                }
            }
            System.out.println(actualStrLength);
        }

    }
}