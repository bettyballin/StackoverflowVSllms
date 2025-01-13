/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomSubsetGenerator {
    public static void main(String[] stringArray) {
        List<String> list = RandomSubsetGenerator.getItems();
        SecureRandom secureRandom = new SecureRandom();
        ArrayList<String> arrayList = new ArrayList<String>(5);
        for (int i = 0; i < 5; ++i) {
            int n = secureRandom.nextInt(list.size());
            arrayList.add(list.remove(n));
        }
        System.out.println(arrayList);
    }

    public static List<String> getItems() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Item1");
        arrayList.add("Item2");
        arrayList.add("Item3");
        arrayList.add("Item4");
        arrayList.add("Item5");
        arrayList.add("Item6");
        arrayList.add("Item7");
        arrayList.add("Item8");
        arrayList.add("Item9");
        arrayList.add("Item10");
        return arrayList;
    }
}
