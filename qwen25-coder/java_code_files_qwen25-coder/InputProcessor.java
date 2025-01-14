public class InputProcessor {
    public String processUserInput(String input) {
        // Trim input to remove any leading or trailing whitespace
        String trimmedInput = (input != null) ? input.trim() : null;

        // Check if the trimmed input is null or empty string
        if (trimmedInput == null || trimmedInput.isEmpty()) {
            return null; // Return as NULL to represent not set
        }

        // Otherwise, return the trimmed input
        return trimmedInput;
    }
    public static void main(String[] args) {
    }
}