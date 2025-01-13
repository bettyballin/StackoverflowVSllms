/*
 * Decompiled with CFR 0.152.
 */
import java.text.BreakIterator;
import java.util.Locale;

public class Main_518 {
    public static void main(String[] stringArray) {
        String string = "This is a long piece of text that needs to be wrapped.";
        String string2 = Main_518.wrapText(string, 20);
        System.out.println(string2);
    }

    public static String wrapText(String string, int n) {
        BreakIterator breakIterator = BreakIterator.getLineInstance(Locale.US);
        breakIterator.setText(string);
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = breakIterator.first();
        int n3 = breakIterator.next();
        while (n3 != -1) {
            stringBuilder.append(string.substring(n2, n3));
            if (stringBuilder.length() - stringBuilder.lastIndexOf("\n") > n) {
                stringBuilder.insert(stringBuilder.lastIndexOf(" ") + 1, "\n");
            }
            n2 = n3;
            n3 = breakIterator.next();
        }
        return stringBuilder.toString();
    }
}
