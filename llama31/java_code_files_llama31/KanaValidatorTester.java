/*
 * Decompiled with CFR 0.152.
 */
public class KanaValidatorTester {
    public static void main(String[] stringArray) {
        KanaValidator kanaValidator = new KanaValidator();
        String string = "\u00e3\u0081\u201c\u00e3\u201a\u201c\u00e3\u0081\u00ab\u00e3\u0081\u201d";
        if (kanaValidator.isHiragana(string)) {
            System.out.println("Valid hiragana input");
        } else {
            System.out.println("Invalid input");
        }
    }
}
