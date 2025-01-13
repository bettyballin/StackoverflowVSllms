/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;

public class ObjectDeduplicator {
    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("apple");
        HashSet hashSet = new HashSet(arrayList);
        ArrayList arrayList2 = new ArrayList(hashSet);
        System.out.println(arrayList2);
    }
}
