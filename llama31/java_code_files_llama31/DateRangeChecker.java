/*
 * Decompiled with CFR 0.152.
 */
public class DateRangeChecker {
    public static boolean isInRange(int n, int n2, int n3) {
        int n4 = DateRangeChecker.convertDateToMinutes(n);
        int n5 = DateRangeChecker.convertDateToMinutes(n2);
        int n6 = DateRangeChecker.convertDateToMinutes(n3);
        if (n6 < n5) {
            n6 += 10080;
        }
        return n4 >= n5 && n4 <= n6;
    }

    private static int convertDateToMinutes(int n) {
        int n2 = n / 10000;
        int n3 = n % 10000 / 100;
        int n4 = n % 100;
        int n5 = (n2 - 1) * 24 * 60;
        return n5 + n3 * 60 + n4;
    }

    public static void main(String[] stringArray) {
    }
}
