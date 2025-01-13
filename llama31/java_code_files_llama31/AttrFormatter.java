/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class AttrFormatter {
    Map<String, String> tagAttrs = new HashMap<String, String>();
    String attrd = String.format("%s='%s'", "attr", this.tagAttrs.get("attr"));

    public static void main(String[] stringArray) {
        AttrFormatter attrFormatter = new AttrFormatter();
        attrFormatter.tagAttrs.put("attr", "value");
        System.out.println(attrFormatter.attrd);
    }
}
