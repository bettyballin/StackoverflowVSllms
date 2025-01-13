/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_598 {
    public static int findMaxLen(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(String::length).max().orElse(0);
    }

    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"apple", "banana", "cherry"};
        System.out.println(Main_598.findMaxLen(stringArray2));
    }
}
