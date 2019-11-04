import com.nitin.utils.GenericStack;

class QueueWithTwoStacks<T> {
    GenericStack<T> s1, s2;

    public QueueWithTwoStacks(Object dataType) {
        this.s1 = new GenericStack<T>(dataType);
        this.s2 = new GenericStack<T>(dataType);
    }

    public boolean enqueue(T data) {
        return this.s1.push(data);
    }

    public T dequeue() {
        if (!this.s2.isStackEmpty()) {
            return this.s2.pop();
        } else if (this.s2.isStackEmpty() && this.s1.stackLength() == 1) {
            return this.s1.pop();
        } else {
            while (!this.s1.isStackEmpty()) {
                this.s2.push(this.s1.pop());
            }
            return this.s2.pop();
        }
    }

    public int queueLength() {
        return this.s1.stackLength() + this.s2.stackLength();
    }
}

class QueueWithTwoStacksTester {
    public static void main(String args[]) {
        
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<Integer>(Integer);

        q1.enqueue(1);
        System.out.println(q1.dequeue());
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        System.out.println("queue length= " + q1.queueLength());

        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println("queue length= " + q1.queueLength());

    }
}