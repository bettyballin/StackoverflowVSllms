/*
 * Decompiled with CFR 0.152.
 */
public class Main_145 {
    public static void main(String[] stringArray) {
        String string = "My name is X Y Z";
        System.out.println(Main_145.reverseWords(string));
    }

    public static String reverseWords(String string) {
        char[] cArray = string.toCharArray();
        Main_145.reverse(cArray, 0, cArray.length - 1);
        int n = 0;
        for (int i = 0; i < cArray.length; ++i) {
            if (cArray[i] != ' ') continue;
            Main_145.reverse(cArray, n, i - 1);
            n = i + 1;
        }
        Main_145.reverse(cArray, n, cArray.length - 1);
        return new String(cArray);
    }

    public static void reverse(char[] cArray, int n, int n2) {
        while (n < n2) {
            char c = cArray[n];
            cArray[n] = cArray[n2];
            cArray[n2] = c;
            ++n;
            --n2;
        }
    }
}
