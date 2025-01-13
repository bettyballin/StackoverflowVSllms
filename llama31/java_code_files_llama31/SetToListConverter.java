/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;

public class SetToListConverter {
    public static void main(String[] stringArray) {
        SetToListConverter setToListConverter = new SetToListConverter();
        setToListConverter.convertSetToList();
    }

    public void convertSetToList() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Hello");
        hashSet.add("World");
        ArrayList arrayList = new ArrayList(hashSet);
        String string = (String)arrayList.get(0);
        System.out.println(string);
    }
}
