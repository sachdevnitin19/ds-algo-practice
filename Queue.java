import java.io.*;

class Queue {
    static final int MAX = 10;
    int front, back;
    char qArr[] = new char[MAX];

    Queue() {
        front = -1;
        back = -1;
    }

    void enqueue(int qElem) {
        if ((front == MAX - 1 && back == 0) || (back > front && front == back - 1)) {
            System.out.println("Queue full");
        } else {
            if (front == -1 && back == -1) {
                front++;
                back++;
            }else if(front<MAX-1){
                front++;
            }else if(back>0 && front!=back-1){
                if(front==Max-1) front=0;
                else front++;
            }
            qArr[front] = qElem;
        }
    }
    void printQueue(){
        int frontCopy=front,backCopy=back;
        if(front==-1 && back==-1) System.out.println("Queue is Empty");
        else{
            if(front>back){
                while(frontCopy>=backCopy){
                    System.out.print(qArr[frontCopy--]+"\t");
                }
            }else if(back>front){
                while(frontCopy>=0){
                    System.out.print(qArr[frontCopy--]+"\t");
                }
                backCopy=MAX-1;
                while(backCopy>=back){
                    System.out.print(qArr[backCopy--]+"\t");
                }
            }
        }
    }

}

class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}