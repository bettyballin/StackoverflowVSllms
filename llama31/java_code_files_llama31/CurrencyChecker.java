/*
 * Decompiled with CFR 0.152.
 */
public class CurrencyChecker {
    public static void main(String[] stringArray) {
        char c = '$';
        if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CURRENCY_SYMBOLS) {
            System.out.println(c + " is a currency symbol");
        } else {
            System.out.println(c + " is not a currency symbol");
        }
    }
}
