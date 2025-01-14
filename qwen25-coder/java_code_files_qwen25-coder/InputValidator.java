public class InputValidator {
    // Example of input validation to prevent injection attacks
    public boolean validateInput(String userInput) {
        return userInput.matches("[a-zA-Z0-9 ]*");
    }

    public static void main(String[] args) {
    }
}