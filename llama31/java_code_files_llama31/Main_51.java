/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class Main_51 {
    public static String getUserName(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", "User 1");
        hashMap.put("2", "User 2");
        hashMap.put("3", "User 3");
        return hashMap.getOrDefault(string, "Unknown User");
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_51.getUserName("1"));
        System.out.println(Main_51.getUserName("4"));
    }
}
