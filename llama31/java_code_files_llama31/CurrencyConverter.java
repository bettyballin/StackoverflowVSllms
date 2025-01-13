/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverter {
    public static void main(String[] stringArray) {
        String string = "50c/70c";
        Pattern pattern = Pattern.compile("([\\d]*)(?:c)?$|([\\d]*)$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String string2;
            String string3 = string2 = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            if (string.endsWith("c")) {
                double d = Double.parseDouble(string2) / 100.0;
                System.out.println(d);
            } else {
                System.out.println(string2);
            }
        }
    }
}
