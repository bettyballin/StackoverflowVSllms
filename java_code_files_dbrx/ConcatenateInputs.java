public class ConcatenateInputs {
    public static void main(String[] args) {
        int textBoxCount = 3; // Number of text boxes
        StringBuilder concatenatedInputs = new StringBuilder();
        for (int i = 0; i < textBoxCount; ++i) {
            if (concatenatedInputs.length() > 0) {
                concatenatedInputs.append((char) 31); // Use the unit separator character as a delimiter
            }
            String input = getUserInputFromTextBox(i);
            concatenatedInputs.append(input);
        }
        // Output the result
        System.out.println("Concatenated Inputs: " + concatenatedInputs.toString());
    }
    
    // Simulate getting user input from text box i
    private static String getUserInputFromTextBox(int i) {
        // For simplicity, we can just return some dummy data or read from console
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter input for text box " + i + ": ");
        String input = scanner.nextLine();
        return input;
    }
}