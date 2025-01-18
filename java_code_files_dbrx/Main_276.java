import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // Create an instance of Main
        Main main = new Main();
        try {
            // Example usage, provide a sample input
            String testInput = "(a(bc)d)";
            main.check(testInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void check(String stmt) throws Exception {
        Stack<Integer> stack = new Stack<>();
        StringBuilder token = new StringBuilder();
        List<String> parts = new ArrayList<>();

        for (int i = 0; i < stmt.length(); ++i) {
            char c = stmt.charAt(i);

            if (c == '(') {
                stack.push(i);
                continue;
            }

            if (c == ')') {
                Integer lastOpenedParenthesisPosition = stack.pop();
                parts.add(getTokenOnLastPoppedParenthesisIndex(stmt, token, lastOpenedParenthesisPosition));
                token = new StringBuilder();
                continue;
            }

            if (stack.isEmpty()) {
                token.append(c);
            } else {
                token.insert(0, c); // Insert to make it read from right-to-left on last parenthesis popped's token
            }
        }

        Collections.reverse(parts);  // Reverse the order as we are using stack which maintains Last In First Out (LIFO)
        // Now parts contains PART0, PART1, PART2, PART3 in expected order

        // Print the parts
        for (String part : parts) {
            System.out.println(part);
        }
    }

    /**
     * This method will return token up to index where last opened parenthesis was popped from stack.
     */
    private String getTokenOnLastPoppedParenthesisIndex(String input, StringBuilder builder, int latestOpenedParenthesis) {
        int start = latestOpenedParenthesis; // Here we assume your string length is less than 10 otherwise use a List to store indexes.
        String result = input.substring(start + 1).replace(")", "")
                         .concat(builder.toString());   // Concatenation to make sure token includes every character between '(' and ')'.
        return removeMultipleAdjacentWhitespaces(result);
    }
    
    private String removeMultipleAdjacentWhitespaces(String input) {
        if (input == null || input.length() < 2) // If less than or equal to 1 char, there is nothing to do here
            return input;

        StringBuilder sb = new StringBuilder();
        boolean prevWhiteSpace = false;
        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (prevWhiteSpace) continue; // Ignore multiple whitespace characters in series
                prevWhiteSpace = true;
            } else {
                prevWhiteSpace = false; // Reset the flag
            }
            sb.append(c); // Append this char to buffer
        }
        return sb.toString();
    }
}