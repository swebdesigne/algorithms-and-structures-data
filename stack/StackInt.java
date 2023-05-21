package stack;

public class StackInt {
    private final int maxSize;
    private int top;
    private final int[] stackArray;

    public StackInt(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stackArray = new int[maxSize];
    }

    public void push(int value) {
        stackArray[++top] = value;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public int peekN(int n) {
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

