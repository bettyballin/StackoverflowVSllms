/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] stringArray) {
        String string = "^(?=.*[a-zA-Z].*[a-zA-Z])(?=.*\\d.*\\d)[a-zA-Z0-9]{6}$";
        Pattern pattern = Pattern.compile(string);
        System.out.println(pattern.matcher("xx12ab").matches());
        System.out.println(pattern.matcher("x12345").matches());
        System.out.println(pattern.matcher("xxxxx1").matches());
        System.out.println(pattern.matcher("xxx123").matches());
    }
}
