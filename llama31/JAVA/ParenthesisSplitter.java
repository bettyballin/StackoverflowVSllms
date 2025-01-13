import java.lang.String;
import java.util.Stack;

public class ParenthesisSplitter {
    public static void check(String stmt) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < stmt.length(); i++) {
            char c = stmt.charAt(i);
            if (c == '(') {
                stack.push(stmt.substring(start, i));
                start = i + 1;
            } else if (c == ')') {
                String part = stmt.substring(start, i);
                System.out.println(part);
                start = i + 1;
                if (!stack.isEmpty()) {
                    String parent = stack.pop();
                    check(parent + part);
                }
            }
        }
    }

    public static void main(String[] args) {
        check("(PART0(PART1(PART2)(PART3)))");
    }
}