/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main_819 {
    public static String buildDelimitedString(List<String> list, String string) {
        StringJoiner stringJoiner = new StringJoiner(string);
        for (String string2 : list) {
            stringJoiner.add(string2);
        }
        return stringJoiner.toString();
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
        String string = Main_819.buildDelimitedString(arrayList, ",");
        System.out.println(string);
    }
}
