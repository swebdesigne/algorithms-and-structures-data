package stack;

public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = (char) theStack.pop();
                        if (
                            (ch == '}' && chx != '{')
                            || (ch == ']' && chx != '[')
                            || (ch == ')' && chx != '(')
                        ) {
                            System.out.println("Error: " + ch + " at" + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at" + i);
                    }
                default:
                    break;
            }
        }
        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
