/*
 * Decompiled with CFR 0.152.
 */
public class HumanReadable {
    private static final String[] ones = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String humanReadable(int n) {
        if (n == 0) {
            return "zero";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (n < 0) {
            stringBuilder.append("minus ");
            n = -n;
        }
        int n2 = n / 1000000000;
        int n3 = n % 1000000000 / 1000000;
        int n4 = n % 1000000 / 1000;
        int n5 = n % 1000;
        if (n2 > 0) {
            stringBuilder.append(HumanReadable.humanReadable(n2)).append(" billion");
            if (n3 > 0 || n4 > 0 || n5 > 0) {
                stringBuilder.append(", ");
            }
        }
        if (n3 > 0) {
            stringBuilder.append(HumanReadable.humanReadable(n3)).append(" million");
            if (n4 > 0 || n5 > 0) {
                stringBuilder.append(", ");
            }
        }
        if (n4 > 0) {
            stringBuilder.append(HumanReadable.humanReadable(n4)).append(" thousand");
            if (n5 > 0) {
                stringBuilder.append(", ");
            }
        }
        if (n5 > 0) {
            stringBuilder.append(HumanReadable.humanReadableRest(n5));
        }
        return stringBuilder.toString();
    }

    private static String humanReadableRest(int n) {
        if (n < 10) {
            return ones[n];
        }
        if (n < 20) {
            return teens[n - 10];
        }
        if (n < 100) {
            return tens[n / 10] + (String)(n % 10 > 0 ? "-" + ones[n % 10] : "");
        }
        if (n < 1000) {
            if (n % 100 == 0) {
                return ones[n / 100] + " hundred";
            }
            return ones[n / 100] + " hundred and " + HumanReadable.humanReadableRest(n % 100);
        }
        return "";
    }

    public static void main(String[] stringArray) {
    }
}
