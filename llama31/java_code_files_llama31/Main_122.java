/*
 * Decompiled with CFR 0.152.
 */
public class Main_122 {
    public static void main(String[] stringArray) {
        System.out.println(Main_122.getSubstringInParentheses("GREECE (+30)"));
    }

    public static String getSubstringInParentheses(String string) {
        int n = string.indexOf(40);
        int n2 = string.indexOf(41);
        if (n != -1 && n2 != -1 && n < n2) {
            return string.substring(n + 1, n2);
        }
        return "";
    }
}
