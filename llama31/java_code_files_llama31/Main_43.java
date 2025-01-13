/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Main_43 {
    public static void main(String[] stringArray) {
        ArrayList arrayList = new ArrayList();
        String string = null;
        if (!arrayList.isEmpty()) {
            for (HashMap hashMap : arrayList) {
                if (!hashMap.containsKey("lang") || !((String)hashMap.get("lang")).equals("es")) continue;
                string = (String)hashMap.get("title");
            }
        }
        System.out.println(string);
    }
}
