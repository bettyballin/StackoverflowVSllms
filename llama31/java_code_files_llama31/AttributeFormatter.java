/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class AttributeFormatter {
    public static void main(String[] stringArray) {
        AttributeFormatter attributeFormatter = new AttributeFormatter();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("attr", "value");
        String string = "attr";
        String string2 = String.format("%s='%s'", string, hashMap.get(string));
        System.out.println(string2);
    }
}
