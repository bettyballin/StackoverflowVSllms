import java.lang.String;

public class InputEscaper_1_1 {
    public static void main(String[] args) {
        InputEscaper_1 ie = new InputEscaper_1();
        String userInput = ie.userInput;
        String escapedInput = ie.escapeInput(userInput);
        System.out.println(escapedInput);
    }

    String userInput = "user-input data";

    String escapeInput(String input) {
        return input.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'");
    }
}