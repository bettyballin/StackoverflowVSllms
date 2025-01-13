/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main_222 {
    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            System.out.println("Processing element: " + string);
            if (!string.equals("Cherry")) continue;
            iterator.remove();
        }
        System.out.println("List after removal: " + String.valueOf(arrayList));
    }
}
