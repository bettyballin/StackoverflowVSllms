/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class Main_587 {
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(string).append(",");
        }
        String string = stringBuilder.toString().replaceAll(",$", "");
        System.out.println(string);
    }
}
