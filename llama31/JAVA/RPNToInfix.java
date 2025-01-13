import java.util.Stack;

public class RPNToInfix {
    public static String rpnToInfix(String rpn) {
        Stack<String> stack = new Stack<>();

        for (String token : rpn.split(" ")) {
            if (isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infixExpression = "(" + operand1 + " " + token + " " + operand2 + ")";
                stack.push(infixExpression);
            } else {
                stack.push(token);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        System.out.println(rpnToInfix("3 4 +"));  // Output: (3 + 4)
    }
}