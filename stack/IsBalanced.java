package stack;

import java.util.Stack;

public class IsBalanced {
    public static boolean isOpen(char c) {
        return c == '{' || c == '[' || c == '(';
    }

        public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (isOpen(str.charAt(i))) stack.push(str.charAt(i));
            else {
                if (!stack.isEmpty() && isPair(stack.peek(), str.charAt(i))) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPair(char open, char close) {
        return (open == '{' && close == '}') || (open == '(' && close == ')') || (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        System.out.println(IsBalanced.isBalanced("()({[]}())")); //true
        System.out.println(IsBalanced.isBalanced("{}")); // true
        System.out.println(IsBalanced.isBalanced("}{")); // false
        System.out.println(IsBalanced.isBalanced("")); // true
        System.out.println(IsBalanced.isBalanced("(()")); // false
        System.out.println(IsBalanced.isBalanced("())")); // false
        System.out.println(IsBalanced.isBalanced("([)]")); // false
    }
}
