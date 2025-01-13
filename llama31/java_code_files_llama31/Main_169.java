/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_169 {
    public static void main(String[] stringArray) {
        String string = "<i><b>test<i>ing</i>";
        Pattern pattern = Pattern.compile("<([^>]+)>(?!.*</\\1>)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println("Unclosed tag: " + matcher.group(1));
        }
    }
}
