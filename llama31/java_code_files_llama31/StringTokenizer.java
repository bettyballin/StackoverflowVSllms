/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class StringTokenizer {
    public static String[] split(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        for (char c : string.toCharArray()) {
            if (c == '\"') {
                bl = !bl;
                continue;
            }
            if (c == ',' && !bl) {
                arrayList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(c);
        }
        arrayList.add(stringBuilder.toString());
        return arrayList.toArray(new String[0]);
    }

    public static void main(String[] stringArray) {
        String string = "a,\"string, with\",various,\"values, and some\",quoted";
        Object[] objectArray = StringTokenizer.split(string);
        System.out.println(Arrays.toString(objectArray));
    }
}
