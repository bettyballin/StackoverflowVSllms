/*
 * Decompiled with CFR 0.152.
 */
public class LuhnValidator {
    public boolean validateLuhn(String string) {
        int n;
        int n2 = 0;
        boolean bl = false;
        for (n = string.length() - 2; n >= 0; --n) {
            int n3 = Character.getNumericValue(string.charAt(n));
            if (bl && (n3 *= 2) > 9) {
                n3 -= 9;
            }
            n2 += n3;
            bl = !bl;
        }
        n = Character.getNumericValue(string.charAt(string.length() - 1));
        return n2 * 9 % 10 == n;
    }

    public static void main(String[] stringArray) {
        LuhnValidator luhnValidator = new LuhnValidator();
        System.out.println(luhnValidator.validateLuhn("79927398713"));
    }
}
