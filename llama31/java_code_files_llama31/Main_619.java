/*
 * Decompiled with CFR 0.152.
 */
public class Main_619 {
    public static int findFirstPrefixMatch(String[] stringArray, String string) {
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].startsWith(string)) continue;
            return i;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"ab", "abd", "abdf", "abz"};
        String string = "abd";
        int n = Main_619.findFirstPrefixMatch(stringArray2, string);
        System.out.println(n);
    }
}
