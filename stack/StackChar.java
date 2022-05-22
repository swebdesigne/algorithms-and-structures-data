package stack;

public class StackChar {
    private int maxSize;
    private int top;
    private char[] stackArray;

    public StackChar(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stackArray = new char[maxSize];
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public char peekN(int n) {
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

