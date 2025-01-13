/*
 * Decompiled with CFR 0.152.
 */
public class ExcelColumnTranslator {
    public static int translate(String string) {
        int n = 0;
        for (char c : string.toUpperCase().toCharArray()) {
            n = n * 26 + (c - 65 + 1);
        }
        return n;
    }

    public static void main(String[] stringArray) {
        System.out.println(ExcelColumnTranslator.translate("A"));
        System.out.println(ExcelColumnTranslator.translate("Z"));
        System.out.println(ExcelColumnTranslator.translate("AA"));
        System.out.println(ExcelColumnTranslator.translate("AZ"));
    }
}
