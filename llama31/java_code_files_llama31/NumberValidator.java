/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

class NumberValidator {
    private Pattern pattern = Pattern.compile("^-?\\d{1,3}(,\\d{3})*(\\.\\d+)?$");

    public boolean isANumber(String string) {
        return this.pattern.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
        NumberValidator numberValidator = new NumberValidator();
        System.out.println(numberValidator.isANumber("123.45"));
        System.out.println(numberValidator.isANumber("-67.89"));
        System.out.println(numberValidator.isANumber("123,456.78"));
        System.out.println(numberValidator.isANumber("invalid"));
    }
}
