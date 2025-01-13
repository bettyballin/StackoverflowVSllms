/*
 * Decompiled with CFR 0.152.
 */
public class Main_52 {
    public static void main(String[] stringArray) {
        System.out.println(Main_52.decimalToColumn(0));
        System.out.println(Main_52.decimalToColumn(25));
        System.out.println(Main_52.decimalToColumn(26));
        System.out.println(Main_52.decimalToColumn(702));
    }

    public static String decimalToColumn(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n >= 0) {
            int n2 = n % 26;
            stringBuilder.insert(0, (char)(65 + n2));
            n = n / 26 - 1;
        }
        return stringBuilder.toString();
    }
}
