/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSquareCalculator {
    public static void main(String[] stringArray) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Integer n : list) {
            arrayList.add(n * n);
        }
        System.out.println(arrayList);
    }
}
