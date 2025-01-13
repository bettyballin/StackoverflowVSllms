/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class FormValidator {
    public static void main(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("key", "ETC");
        String string = (String)hashMap.get("key");
        if (string.equals("ETC")) {
            System.out.println("Please select an option.");
        } else {
            System.out.println("Form submission successful.");
        }
    }
}
