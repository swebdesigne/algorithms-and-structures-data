package queue;

public class Deque {
    private final int maxSiZe;
    private final int[] array;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int maxSiZe) {
        this.maxSiZe = maxSiZe;
        this.array = new int[maxSiZe];
        this.front = this.nItems = 0;
        this.rear = -1;
    }

    public void insertRight(int value) {
        if (rear >= maxSiZe - 1) {
            rear = -1;
        }
        array[++rear] = value;
        nItems++;
    }

    public void insertLeft(int value) {
        if (rear <= 0) {
            rear = maxSiZe;
        }
        if (rear > 0)
            array[--rear] = value;
        nItems++;
    }

    public int removeRight() {
        int tmp = array[front++];
        if (front == maxSiZe) front = 0;
        nItems--;
        return tmp;
    }

    public int removeLeft() {
        if (front <= 0) front = maxSiZe;
        int tmp = array[--front];
        nItems--;
        return tmp;
    }

    public int[] arr() {
        return array;
    }

    public void displayRight() {
        while (!isEmpty()) {
            System.out.println(removeRight());
        }
    }

    public void displayLeft() {
        while (!isEmpty()) {
            System.out.println(removeLeft());
        }
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSiZe;
    }

    public static void main(String[] args) {
        Deque deque = new Deque(6);
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);
        deque.displayRight();
    }
}
