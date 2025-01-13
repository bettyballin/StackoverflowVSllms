/*
 * Decompiled with CFR 0.152.
 */
public class TNTChecksumValidator {
    public static boolean isValidTNTConsignmentNumber(String string) {
        int[] nArray = new int[]{8, 6, 4, 2, 3, 5, 9, 7};
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            int n2 = Character.getNumericValue(string.charAt(i));
            n += nArray[i % nArray.length] * n2;
        }
        return n % 11 == 0;
    }

    public static void main(String[] stringArray) {
        System.out.println(TNTChecksumValidator.isValidTNTConsignmentNumber("12345678"));
    }
}
