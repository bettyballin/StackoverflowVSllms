/*
 * Decompiled with CFR 0.152.
 */
public class Main_400 {
    public static void main(String[] stringArray) {
        String string = "example";
        int n = Main_400.calculate(string);
        System.out.println(n);
    }

    public static int calculate(String string) {
        int n = string.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            n2 = n2 * 31 + c;
        }
        return n2;
    }
}
