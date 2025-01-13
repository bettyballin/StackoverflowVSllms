/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class ContextManager {
    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("myVariable", string);
        System.out.println(hashMap.get("myVariable"));
    }
}
