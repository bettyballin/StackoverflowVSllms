/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class StateExample {
    public static void main(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("ALABAMA", "AL");
        hashMap.put("ALASKA", "AK");
        hashMap.put("WYOMING", "WY");
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("The abbreviation for " + (String)entry.getKey() + " is " + (String)entry.getValue());
        }
    }
}
