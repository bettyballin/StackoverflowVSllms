/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class Main_407 {
    public static void main(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String[] stringArray2 = new String[]{"key1", "key2", "key3"};
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        for (String string : stringArray2) {
            if (hashMap.containsKey(string)) {
                System.out.println("Key " + string + " is present in the map.");
                continue;
            }
            System.out.println("Key " + string + " is not present in the map.");
        }
    }
}
