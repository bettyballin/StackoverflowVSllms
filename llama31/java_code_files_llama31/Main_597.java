/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Comparator;

public class Main_597 {
    public static int findMaxLen(String[] stringArray) {
        return Arrays.stream(stringArray).max(Comparator.comparingInt(String::length)).map(String::length).orElse(0);
    }

    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"apple", "banana", "orange"};
        System.out.println(Main_597.findMaxLen(stringArray2));
    }
}
