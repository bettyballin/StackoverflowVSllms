import java.lang.String;

public class InputEscaper {
    String userInput = "user-input data";
    String escapedInput = userInput.replace("\"", "&quot;").replace("'", "&#x27;");

    public static void main(String[] args) {
        InputEscaper escaper = new InputEscaper();
        System.out.println(escaper.escapedInput);
    }
}