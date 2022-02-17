package stack;

public class Reverser {
    private String input, output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        input.chars().forEach(theStack::push);
        output = "";
        while (!theStack.isEmpty()) {
            output += (char) theStack.pop();
        }
        return output;
    }
}
