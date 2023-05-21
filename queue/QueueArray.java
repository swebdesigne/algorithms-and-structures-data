package queue;

/**
 * Очередь основана на массиве
 * Реализация очереди со счетчиками элементов
 */
public class QueueArray {
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        this.queArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove() {
        long tmp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return tmp;
    }

    public void display() {
        int tmp = 0;
        while (tmp < rear + 1) {
            System.out.println(queArray[tmp]);
            tmp++;
        }
    }
    public void displayWithRemove() {
        while (!isEmpty()) {
            System.out.println(remove());
        }
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}

/**
 * Очередь основана на массиве
 * Реализация очереди без счетчика элементов
 */
class QueueArray2 {
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;

    public QueueArray2(int maxSize) {
        this.maxSize = maxSize + 1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public void display() {
        for (int i = 0; i < queArray.length - 1; i++) {
            System.out.println(queArray[i]);
        }
    }

    public long remove() {
        long tmp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return tmp;
    }

    public long peek() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front + maxSize - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front || front + maxSize - 2 == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front) + (rear + 1);
        }
    }
}

class QueueApp {
    public static void main(String[] args) {
        QueueArray theQueueArray = new QueueArray(5);
        theQueueArray.insert(10);
        theQueueArray.insert(20);
        theQueueArray.insert(30);
        theQueueArray.insert(40);

        theQueueArray.displayWithRemove();
        System.out.println(theQueueArray.isEmpty());
        System.exit(0);

        theQueueArray.remove();
        theQueueArray.remove();
        theQueueArray.remove();

        theQueueArray.insert(50);
        theQueueArray.insert(60);
        theQueueArray.insert(70);
        theQueueArray.insert(80);

        while (!theQueueArray.isEmpty()) {
            long n = theQueueArray.remove();
            System.out.println(n);
            System.out.println(" ");
        }
    }
}
