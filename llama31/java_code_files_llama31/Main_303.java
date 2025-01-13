/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class Main_303 {
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(string).append(",");
        }
        String string = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        System.out.println(string);
    }
}
