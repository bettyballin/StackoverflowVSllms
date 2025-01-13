import java.util.regex.Pattern;

class NumberValidator {
    private Pattern pattern;

    public NumberValidator() {
        this.pattern = Pattern.compile("^-?\\d{1,3}(,\\d{3})*(\\.\\d+)?$");
    }

    public boolean isANumber(String input) {
        return this.pattern.matcher(input).matches();
    }

    public static void main(String[] args) {
        NumberValidator validator = new NumberValidator();
        System.out.println(validator.isANumber("123.45")); // true
        System.out.println(validator.isANumber("-67.89")); // true
        System.out.println(validator.isANumber("123,456.78")); // true
        System.out.println(validator.isANumber("invalid")); // false
    }
}