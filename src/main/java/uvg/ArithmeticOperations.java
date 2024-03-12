package uvg;

import java.util.List;
import java.util.Stack;

public class ArithmeticOperations {

    public int evaluatePrefix(List<String> st) {
        Stack<Integer> stack = new Stack<>();
        String lastOperator = "";  // Initialize variable to store the last encountered operator

        for (int i = st.size() - 1; i >= 0; i--) {
            String e = st.get(i);
            if (isNumeric(e)) {
                stack.push(Integer.parseInt(e));
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();

                // Store the last encountered operator
                if (i == 0) {
                    lastOperator = e;
                }

                // Perform the operation based on the encountered operator
                switch (e) {
                    case "+":
                        stack.push(n1 + n2);
                        break;
                    case "-":
                        stack.push(n1 - n2);
                        break;
                    case "*":
                        stack.push(n1 * n2);
                        break;
                    case "/":
                        stack.push(n1 / n2);
                        break;
                    default:
                        break;
                }
            }
        }

        // Perform the final operation based on the last encountered operator
        while (!lastOperator.isEmpty() && stack.size() > 1) {
            int n1 = stack.pop();
            int n2 = stack.pop();
            switch (lastOperator) {
                case "+":
                    stack.push(n1 + n2);
                    break;
                case "-":
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(n1 * n2);
                    break;
                case "/":
                    stack.push(n1 / n2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + lastOperator);
            }
            lastOperator = "";  // Reset the last operator
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Empty stack after evaluation");
        }

        return stack.pop();  // Return the final result after all operations
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
