/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_733 {
    public static void main(String[] stringArray2) {
        String[][] stringArrayArray = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}};
        String[][] stringArray3 = (String[][])Arrays.stream(stringArrayArray).map(stringArray -> (String[])stringArray.clone()).toArray(n -> new String[n][]);
        System.out.println(Arrays.deepToString((Object[])stringArray3));
    }
}
