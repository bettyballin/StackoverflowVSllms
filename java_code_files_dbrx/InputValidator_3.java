public class InputValidator_3 {
    public void validateInput(Object input) {
        if (input == null) {
            throw new IllegalArgumentException("Null value passed to validateInput(). Please ensure that valid arguments are provided.");
        }
    }
    public static void main(String[] args) {
    }
}