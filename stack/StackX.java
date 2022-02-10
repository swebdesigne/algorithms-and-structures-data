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

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
