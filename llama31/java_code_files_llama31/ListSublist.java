/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class ListSublist {
    public static void main(String[] stringArray) {
        int n;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n = 1; n <= 100; ++n) {
            arrayList.add(n);
        }
        n = 10;
        for (int i = 0; i < arrayList.size(); i += n) {
            System.out.println(arrayList.get(i));
        }
    }
}
