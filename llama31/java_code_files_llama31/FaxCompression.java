/*
 * Decompiled with CFR 0.152.
 */
import java.util.Scanner;

public class FaxCompression {
    public static void main(String[] stringArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String string = scanner.nextLine();
        scanner.close();
        FaxCompression.compress(string);
    }

    public static void compress(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        char c = string.charAt(0);
        int n = 1;
        for (int i = 1; i < string.length(); ++i) {
            if (string.charAt(i) == c) {
                ++n;
                continue;
            }
            stringBuilder.append(n).append(":").append(c).append(" ");
            c = string.charAt(i);
            n = 1;
        }
        stringBuilder.append(n).append(":").append(c);
        System.out.println(stringBuilder.toString());
    }
}
