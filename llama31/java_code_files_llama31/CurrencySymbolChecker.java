/*
 * Decompiled with CFR 0.152.
 */
public class CurrencySymbolChecker {
    public static void main(String[] stringArray) {
        String string = "\\p{Sc}";
        char c = '$';
        if (String.valueOf(c).matches(string)) {
            System.out.println(c + " is a currency symbol");
        } else {
            System.out.println(c + " is not a currency symbol");
        }
    }
}
