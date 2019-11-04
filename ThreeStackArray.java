import java.io.*;
import java.util.Arrays;

class Stack {
    int top, start, end;
    int stackArr[];

    public Stack(int[] arr, int start, int end) {
        top = -1;
        this.stackArr = arr;
        this.start = start;
        this.end = end;
    }

    public boolean isStackFull() {
        return top == end;
    }

    public boolean isStackEmpty() {
        return top == -1;
    }

    public int peek() {
        return stackArr[top];
    }

    public boolean push(int x) {
        if (top == end) {
            System.out.println("Stack full");
            return false;
        } else if (top == -1) {
            top = this.start;
            stackArr[top] = x;
        } else {
            this.stackArr[++top] = x;
        }
        return true;
    }

    public int stackLength() {
        return top < 0 ? 0 : top + 1;
    }

    public int pop() {
        if (top == start) {
            int x = stackArr[top];
            top = -1;
            return x;
        } else if(top!=-1){
            return stackArr[top--];
        }else{
            System.out.println("stack empty");
            return -1;
        }
    }
}

class ThreeStackArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stackSize = Integer.parseInt(br.readLine());
        if(stackSize<3){
            System.out.println("Minimum stack array size is 3");
            System.exit(1);
        }
        int[] stackArr = new int[stackSize];
        int eachStackLen = stackSize / 3;
        int start = 0, mid1 = start + eachStackLen - 1, mid2 = mid1 + eachStackLen, end = stackSize - 1;
        System.out.println(start + " " + mid1 + " " + mid2 + " " + end);
        Stack s1 = new Stack(stackArr, start, mid1);
        Stack s2 = new Stack(stackArr, mid1 + 1, mid2);
        Stack s3 = new Stack(stackArr, mid2 + 1, end);

        s1.push(5);
        s2.push(3);
        s3.push(100);
        System.out.println(Arrays.toString(stackArr));

        s1.push(6);
        s2.push(2);
        s3.push(150);
        System.out.println(Arrays.toString(stackArr));

        s1.push(8);
        s2.push(1);
        s3.push(180);
        System.out.println(Arrays.toString(stackArr));

        s1.push(8);
        s2.push(1);
        s3.push(180);
        System.out.println(Arrays.toString(stackArr));

        System.out.println(s1.pop());
        System.out.println(s2.pop());
        System.out.println(s3.pop());
        System.out.println(Arrays.toString(stackArr));

        System.out.println(s1.pop());
        System.out.println(s2.pop());
        System.out.println(s3.pop());
        System.out.println(Arrays.toString(stackArr));

        System.out.println(s1.pop());
        System.out.println(s2.pop());
        System.out.println(s3.pop());
        System.out.println(Arrays.toString(stackArr));

        System.out.println(s1.pop());
        System.out.println(s2.pop());
        System.out.println(s3.pop());
        System.out.println(Arrays.toString(stackArr));
    }
}