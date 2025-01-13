/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class SecurityValidator {
    public static void main(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("What was your first car?", "Toyota");
        hashMap.put("Where did you grow up?", "New York");
        String string = "Toyota";
        String string2 = "New York";
        String[] stringArray2 = new String[]{string, string2};
        int n = 0;
        int n2 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (stringArray2[n2].equals(entry.getValue())) {
                ++n;
            }
            ++n2;
        }
        if (n >= hashMap.size() / 2) {
            System.out.println("Password reset allowed");
        } else {
            System.out.println("Password reset not allowed");
        }
    }
}
