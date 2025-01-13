/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class Main_302 {
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        String string = String.join((CharSequence)",", list);
        System.out.println(string);
    }
}
