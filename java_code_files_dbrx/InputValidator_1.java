import java.lang.String;
public class InputValidator_1 {
    public String processInput(String userInput) {
        // Check for null
        if (userInput == null || "".equals(userInput.trim())) {
            throw new IllegalArgumentException("Invalid input!");
        }

        // Ensuring that certain characters are not present which could cause code injection attacks:
        String invalidChars = "<>;=#{}";
        for (char c : invalidChars.toCharArray()) {
            if(userInput.contains("" + c)){
                throw new IllegalArgumentException("Illegal character");
            }
        }

        // Process the input here...
        return userInput;
    }
    public static void main(String[] args) {
    }
}