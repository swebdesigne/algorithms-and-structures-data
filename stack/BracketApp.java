package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("Enter string containing delimiters");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }

    private static String getString() throws IOException {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(inp);
        return bfr.readLine();
    }
}
