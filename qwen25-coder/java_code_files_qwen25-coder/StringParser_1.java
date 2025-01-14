import java.util.ArrayList;
import java.util.List;

public class StringParser_1 {

    private void check(String stmt) throws Exception {
        List<String> parts = new ArrayList<>();
        parse(stmt, 0, parts);

        // Print the parts in reverse order as required
        for (int i = parts.size() - 1; i >= 0; i--) {
            System.out.println(parts.get(i));
        }
    }

    private void parse(String stmt, int startIndex, List<String> parts) throws Exception {
        int openParenthesesCount = 0;
        StringBuilder currentPart = new StringBuilder();

        for (int i = startIndex; i < stmt.length(); i++) {
            char c = stmt.charAt(i);
            if (c == '(') {
                if (openParenthesesCount == 1 && currentPart.length() > 0) {
                    // Found the start of a nested part, process it recursively
                    parts.add(currentPart.toString());
                    parse(stmt, i + 1, parts);
                    break; // After processing this level, stop and return to previous recursion
                } else if (openParenthesesCount > 0) {
                    currentPart.append(c);
                }
                openParenthesesCount++;
            } else if (c == ')') {
                openParenthesesCount--;
                if (openParenthesesCount == 1 && i + 1 < stmt.length() && stmt.charAt(i + 1) == '(') {
                    // Current part is completed, continue to next
                    parts.add(currentPart.toString());
                    currentPart.setLength(0);
                } else if (openParenthesesCount == 0) {
                    // Top level complete
                    parts.add(currentPart.toString());
                    return;
                }
            } else {
                if (openParenthesesCount > 0) {
                    currentPart.append(c);
                }
            }
        }

        if (openParenthesesCount != 0) {
            throw new Exception("Mismatched parentheses detected.");
        }
    }

    public static void main(String[] args) {
        try {
            StringParser_1 parser = new StringParser_1();
            parser.check("(PART0(PART1(PART2)(PART3)))");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}