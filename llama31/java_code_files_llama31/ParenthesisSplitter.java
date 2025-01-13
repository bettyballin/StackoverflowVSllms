/*
 * Decompiled with CFR 0.152.
 */
import java.util.Stack;

public class ParenthesisSplitter {
    public static void check(String string) {
        Stack<String> stack = new Stack<String>();
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '(') {
                stack.push(string.substring(n, i));
                n = i + 1;
                continue;
            }
            if (c != ')') continue;
            String string2 = string.substring(n, i);
            System.out.println(string2);
            n = i + 1;
            if (stack.isEmpty()) continue;
            String string3 = (String)stack.pop();
            ParenthesisSplitter.check(string3 + string2);
        }
    }

    public static void main(String[] stringArray) {
        ParenthesisSplitter.check("(PART0(PART1(PART2)(PART3)))");
    }
}
