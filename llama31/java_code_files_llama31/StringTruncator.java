/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Font;
import java.awt.FontMetrics;

public class StringTruncator {
    public static String truncateString(String string, Font font, int n) {
        FontMetrics fontMetrics = new FontMetrics(font){};
        int n2 = fontMetrics.stringWidth(string);
        if (n2 <= n) {
            return string;
        }
        int n3 = string.length() - 1;
        while (fontMetrics.stringWidth(string.substring(0, n3) + "...") > n) {
            --n3;
        }
        return string.substring(0, n3) + "...";
    }

    public static void main(String[] stringArray) {
        Font font = new Font("Arial", 0, 12);
        String string = "This is a very long string that needs to be truncated.";
        int n = 100;
        System.out.println(StringTruncator.truncateString(string, font, n));
    }
}
