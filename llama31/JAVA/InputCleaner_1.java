import java.lang.String;

public class InputCleaner_1_1 {
    public static void main(String[] args) {
        String input = "Hello, World! 123"; // Define the input string
        String cleanInput = input.replaceAll("\\P{L}\\s+", "");
        System.out.println(cleanInput); // Print the cleaned input
    }
}