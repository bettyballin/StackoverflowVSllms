/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class Main_221 {
    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element 1");
        arrayList.add("Element 2");
        arrayList.add("Element 3");
        ArrayList arrayList2 = new ArrayList();
        while (!arrayList.isEmpty()) {
            Object e = arrayList.remove(0);
            System.out.println("Processing element: " + String.valueOf(e));
            arrayList2.add(e);
        }
        System.out.println("Already processed elements: " + String.valueOf(arrayList2));
    }
}
