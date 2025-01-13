import java.util.Stack;

public class RPNConverter {
    public static void main(String[] args) {
        String rpn = "3 4 + 2 *";
        String infix = RPNToInfix.rpnToInfix(rpn);
        System.out.println(infix); // Output: ((3 + 4) * 2)
    }
}

class RPNToInfix {
    public static String rpnToInfix(String rpn) {
        Stack<String> stack = new Stack<>();
        String[] tokens = rpn.split("\\s+"); // Split by one or more spaces
        
        for (String token : tokens) {
            if (token.matches("\\+|-|\\*|/")) { // If token is an operator
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid RPN expression.");
                }
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infixExpression = "(" + operand1 + " " + token + " " + operand2 + ")";
                stack.push(infixExpression);
            } else {
                stack.push(token);
            }
        }
        
        if (stack.size() != 1) {
            throw new RuntimeException("Invalid RPN expression.");
        }
        
        return stack.pop();
    }
}