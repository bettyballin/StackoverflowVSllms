/*
 * Decompiled with CFR 0.152.
 */
import java.util.TreeMap;

public class Main_392 {
    public static void main(String[] stringArray) {
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("banana", "fruit");
        treeMap.put("apple", "fruit");
        treeMap.put("dog", "animal");
        for (String string : treeMap.keySet()) {
            System.out.println(string);
        }
    }
}
