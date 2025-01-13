/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class StringArrayConverter {
    List<?> l = Arrays.asList("a", "b", "c");
    String[] stuff = this.l.toArray(new String[0]);

    public static void main(String[] stringArray) {
        StringArrayConverter stringArrayConverter = new StringArrayConverter();
        System.out.println(Arrays.toString(stringArrayConverter.stuff));
    }
}
