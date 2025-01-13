/*
 * Decompiled with CFR 0.152.
 */
import java.util.Formatter;

public class StringUtil_7 {
    public static String padRight(String string, int n) {
        Formatter formatter = new Formatter();
        formatter.format("%-" + n + "s", string);
        return formatter.toString();
    }

    public static String padLeft(String string, int n) {
        Formatter formatter = new Formatter();
        formatter.format("%" + n + "s", string);
        return formatter.toString();
    }

    public static void main(String[] stringArray) {
    }
}
