/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class Main_818 {
    public static String buildDelimitedString(List<String> list, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(string);
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        boolean bl = true;
        boolean bl2 = true;
        if (bl) {
            arrayList.add("elementName");
        }
        if (bl2) {
            arrayList.add("anotherElementName");
        }
        String string = Main_818.buildDelimitedString(arrayList, ",");
        System.out.println(string);
    }
}
