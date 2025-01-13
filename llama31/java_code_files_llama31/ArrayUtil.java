/*
 * Decompiled with CFR 0.152.
 */
public class ArrayUtil {
    public static String[] removeElement(String[] stringArray, String string) {
        int n = 0;
        for (String string2 : stringArray) {
            if (string2.equals(string)) continue;
            ++n;
        }
        String[] stringArray2 = new String[n];
        int n2 = 0;
        for (String string3 : stringArray) {
            if (string3.equals(string)) continue;
            stringArray2[n2] = string3;
            ++n2;
        }
        return stringArray2;
    }

    public static void main(String[] stringArray) {
    }
}
