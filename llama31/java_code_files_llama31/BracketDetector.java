/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketDetector {
    public static void main(String[] stringArray) {
        String string = "\\[";
        String string2 = "Hello [ World";
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(string2);
        if (matcher.find()) {
            System.out.println("Square bracket found!");
        }
    }
}
