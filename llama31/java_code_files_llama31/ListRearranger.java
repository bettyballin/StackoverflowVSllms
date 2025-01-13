/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class ListRearranger {
    public static void moveElement(ArrayList<String> arrayList, int n, boolean bl) {
        int n2;
        if (arrayList.isEmpty() || n < 0 || n >= arrayList.size()) {
            return;
        }
        int n3 = n2 = bl ? n - 1 : n + 1;
        if (n2 < 0 || n2 >= arrayList.size()) {
            return;
        }
        String string = arrayList.get(n);
        arrayList.set(n, arrayList.get(n2));
        arrayList.set(n2, string);
    }

    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        System.out.println("Original List: " + String.valueOf(arrayList));
        ListRearranger.moveElement(arrayList, 1, true);
        System.out.println("List after moving 'B' up: " + String.valueOf(arrayList));
        ListRearranger.moveElement(arrayList, 2, false);
        System.out.println("List after moving 'C' down: " + String.valueOf(arrayList));
    }
}
