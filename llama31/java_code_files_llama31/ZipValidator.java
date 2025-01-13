/*
 * Decompiled with CFR 0.152.
 */
public class ZipValidator {
    public static boolean isValidZip(String string) {
        String string2 = "^\\d{5}(-\\d{4})?$";
        return string.matches(string2);
    }

    public static void main(String[] stringArray) {
    }
}
