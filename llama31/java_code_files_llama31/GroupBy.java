/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class GroupBy {
    public static void main(String[] stringArray) {
        String[][] stringArrayArray = new String[][]{{"Group1", "Item1"}, {"Group1", "Item2"}, {"Group2", "Item3"}, {"Group2", "Item4"}, {"Group2", "Item5"}, {"Group3", "Item6"}};
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String[] stringArray2 : stringArrayArray) {
            String string = stringArray2[0];
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Group: " + (String)entry.getKey() + ", Count: " + String.valueOf(entry.getValue()));
        }
    }
}
