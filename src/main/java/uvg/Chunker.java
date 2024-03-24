package uvg;

import java.util.ArrayList;
import java.util.Stack;

public class Chunker {

    /**
     * @param rawLispCode
     * @return
     * @description this method analize a String and evaluates every balanced
     *              parenthesis until it gets all of them
     */
    public static ArrayList<String> getChunks(String rawLispCode) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArr = rawLispCode.toCharArray();
        String block = "";

        ArrayList<String> arrTest = new ArrayList<String>();

        for (char character : charArr) {

            if (character == '(') {
                stack.push('(');
            } else if (character == ')') {
                stack.pop();
            }

            block = block + character;

            if (stack.isEmpty() && !block.equals("") && !block.equals(" ")) {
                arrTest.add(block.trim());
                block = "";
            }
        }

        return arrTest;

    }
}
