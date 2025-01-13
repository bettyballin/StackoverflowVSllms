/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class ArrayConverter {
    public static void main(String[] stringArray) {
        ArrayConverter arrayConverter = new ArrayConverter();
        List<String> list = Arrays.asList("a", "b", "c");
        String[] stringArray2 = list.toArray(new String[0]);
    }
}
