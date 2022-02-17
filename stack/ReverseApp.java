package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter a string");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            Reverser reverser = new Reverser(input);
            output = reverser.doRev();
            System.out.println("Reversed " + output);
        }
    }

    private static String getString() throws IOException {
        String s = "";
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(inp);
        s = bfr.readLine();
        return s;
    }
}
