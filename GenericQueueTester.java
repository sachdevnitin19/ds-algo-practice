import com.nitin.utils.GenericQueue;


class GenericQueueTester {
    public static void main(String args[]) {
        GenericQueue<Integer> q1 = new GenericQueue<Integer>();

        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.printQueue();

        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        q1.printQueue();
    }
}