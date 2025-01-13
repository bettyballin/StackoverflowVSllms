/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class StringListConverter {
    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element 1");
        arrayList.add("Element 2");
        arrayList.add("Element 3");
        if (arrayList != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : arrayList) {
                stringBuilder.append(string).append(",");
            }
            String string = stringBuilder.toString().replaceAll(",$", "");
            System.out.println(string);
        }
    }
}
