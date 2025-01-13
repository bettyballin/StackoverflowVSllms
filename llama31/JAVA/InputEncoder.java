import java.lang.String;

public class InputEncoder {
    public static void main(String[] args) {
        InputEncoder encoder = new InputEncoder();
        System.out.println(encoder.encodedInput);
    }

    String userInput = "user-input data";
    String encodedInput = userInput.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
}