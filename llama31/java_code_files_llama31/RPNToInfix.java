/*
 * Decompiled with CFR 0.152.
 */
import java.util.Stack;

class RPNToInfix {
    RPNToInfix() {
    }

    public static String rpnToInfix(String string) {
        String[] stringArray;
        Stack<Object> stack = new Stack<Object>();
        for (String string2 : stringArray = string.split("\\s+")) {
            if (string2.matches("\\+|-|\\*|/")) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid RPN expression.");
                }
                String string3 = (String)stack.pop();
                String string4 = (String)stack.pop();
                String string5 = "(" + string4 + " " + string2 + " " + string3 + ")";
                stack.push(string5);
                continue;
            }
            stack.push(string2);
        }
        if (stack.size() != 1) {
            throw new RuntimeException("Invalid RPN expression.");
        }
        return (String)stack.pop();
    }
}
