import java.io.*;

class Stack {
    static final int MAX = 100;
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
            return '0';
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
            return '0';
        return stackArr[top--];
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

class MMASS {
    static int getCharValue(char c) {
        switch (c) {
        case 'C':
            return 12;
        case 'H':
            return 1;
        default:
            return 16;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
        Stack st = new Stack();
        int finalMass = 0;
        int i = 0, temp=0;

        while (i < formula.length()) {
            char currChar = formula.charAt(i);
            if(currChar=='('){
                st.push(-1);
            }else if(Character.isDigit(currChar)){
                temp=st.pop();
                st.push(temp*Character.getNumericValue(currChar));
                temp=0;
            }else if(currChar==')'){
                temp=0;
                while(st.peek()!=-1){
                    temp+=(st.pop());
                }
                st.pop();
                st.push(temp);
            }else{
                st.push(getCharValue(currChar));
            }
            i++;
        }
        while(!st.isStackEmpty()){
            finalMass+=st.pop();
        }
        System.out.println(finalMass);
    }
}