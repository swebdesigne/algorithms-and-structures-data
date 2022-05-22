package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;
        while (true) {
            System.out.println("Enter postfix: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();
            System.out.println("Evaluates to " + output);
        }
    }

    private static String getString() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(streamReader);
        return bfr.readLine();
    }
}
