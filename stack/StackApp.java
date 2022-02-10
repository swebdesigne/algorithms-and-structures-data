package stack;

public class StackApp {
    public static void main(String[] args) {
        StackX stack = new StackX(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);
        while (!stack.isEmpty()) {
            long value = stack.peek();
            System.out.println(value);
            System.out.print(System.lineSeparator());
        }
    }
}
