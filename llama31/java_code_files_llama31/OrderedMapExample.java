/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderedMapExample {
    public static void main(String[] stringArray) {
        LinkedHashMap<String, Image> linkedHashMap = new LinkedHashMap<String, Image>();
        linkedHashMap.put("id1", new Image("image1"));
        linkedHashMap.put("id2", new Image("image2"));
        linkedHashMap.put("id3", new Image("image3"));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println((String)entry.getKey() + ": " + String.valueOf(entry.getValue()));
        }
    }
}
