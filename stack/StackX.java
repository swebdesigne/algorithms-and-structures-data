package stack;

public class StackX {
    private int maxSize;
    private int top;
    private long[] stackArray;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stackArray = new long[maxSize];
    }

    public void push(long value) {
        stackArray[++top] = value;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public long peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.println(s);
        System.out.println("Stack (bottom --> top): ");
        for (int i = 0; i < size(); i++) {
            System.out.println(peekN(i));
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
