/*
 * Decompiled with CFR 0.152.
 */
public class CreditCardDetector {
    public static String detectCardType(String string) {
        if ((string = string.replaceAll("\\D", "")).startsWith("4") && (string.length() == 13 || string.length() == 16)) {
            return "Visa";
        }
        if (string.startsWith("51") || string.startsWith("52") || string.startsWith("53") || string.startsWith("54") || string.startsWith("55")) {
            return "Mastercard";
        }
        if (string.startsWith("34") || string.startsWith("37")) {
            return "American Express";
        }
        if (string.startsWith("6011") || string.startsWith("64")) {
            return "Discover";
        }
        if (string.startsWith("300") || string.startsWith("301") || string.startsWith("302") || string.startsWith("303") || string.startsWith("304") || string.startsWith("305")) {
            return "Diners Club";
        }
        return "Unknown";
    }

    public static void main(String[] stringArray) {
    }
}
