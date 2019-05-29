import java.io.*;

class Queue {
    static final int MAX = 10;
    int front, back;
    int qArr[] = new int[MAX];

    Queue() {
        front = -1;
        back = -1;
    }

    void enqueue(int qElem) {
        if ((back == MAX - 1 && front == 0) || (front > back && back == front - 1)) {
            System.out.println("Queue full");
        } else {
            if (front == -1 && back == -1) {
                front++;
                back++;
            } else if (back < MAX - 1) {
                back++;
            } else if (front > 0 && back != front - 1) {
                if (back == MAX - 1)
                    back = 0;
                else
                    back++;
            }
            qArr[back] = qElem;
        }
    }

    int dequeue() {
        int tempInt = -1;
        if (front != -1 && back != -1) {
            if (front == back) {
                tempInt = qArr[front];
                front = -1;
                back = -1;
            } else if (front >= 0 && front < back) {
                tempInt = qArr[front++];
            } else if (front > 0 && front > back) {
                if (front == MAX - 1) {
                    tempInt = qArr[front];
                    front = 0;
                }
                tempInt = qArr[front++];
            }
        } else {
            System.out.println("Queue is empty");
        }
        return tempInt;
    }

    void printQueue() {
        int frontCopy = front, backCopy = back;
        if (front == -1 && back == -1)
            System.out.println("Queue is Empty");
        else {
            if (front <= back) {
                while (frontCopy <= backCopy) {
                    System.out.print(qArr[frontCopy++] + "\t");
                }
            } else if (front > back) {
                while (frontCopy <= MAX - 1) {
                    System.out.print(qArr[frontCopy++] + "\t");
                }
                backCopy = 0;
                while (backCopy <= back) {
                    System.out.print(qArr[backCopy++] + "\t");
                }
            }
        }
    }

}

class QDriver {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue myQ = new Queue();
        System.out.println("1. enqueue");
        System.out.println("2. dequeue");
        System.out.println("3. print queue");
        System.out.println("0. Exit");
        int choice = Integer.parseInt(br.readLine());
        while (choice != 0) {

            switch (choice) {
            case 1:
                myQ.enqueue(Integer.parseInt(br.readLine()));
                break;
            case 2:
                int newElem = myQ.dequeue();
                if (newElem != -1)
                    System.out.println("Elem from Q:-" + newElem);
                break;
            case 3:
                myQ.printQueue();
                break;
            }
            System.out.println("");
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. print queue");
            System.out.println("0. Exit");
            System.out.println("");
            choice = Integer.parseInt(br.readLine());
        }
    }
}