/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class Main_745 {
    public static void main(String[] stringArray) {
        Object[][] objectArray;
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("Row1Col1");
        arrayList2.add("Row1Col2");
        arrayList.add(arrayList2);
        ArrayList<String> arrayList3 = new ArrayList<String>();
        arrayList3.add("Row2Col1");
        arrayList3.add("Row2Col2");
        arrayList.add(arrayList3);
        Object[][] objectArray2 = objectArray = (Object[][])arrayList.stream().map(list -> list.toArray()).toArray(n -> new Object[n][]);
        int n2 = objectArray2.length;
        for (int i = 0; i < n2; ++i) {
            Object[] objectArray3;
            for (Object object : objectArray3 = objectArray2[i]) {
                System.out.print(String.valueOf(object) + " ");
            }
            System.out.println();
        }
    }
}
