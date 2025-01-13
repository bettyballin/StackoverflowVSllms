/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class ImagePrinter {
    public static void main(String[] stringArray) {
        HashMap<String, Image> hashMap = new HashMap<String, Image>();
        hashMap.put("key1", new Image());
        hashMap.put("key2", new Image());
        for (Image image : hashMap.values()) {
            System.out.println(image);
        }
    }
}
