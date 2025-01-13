import java.util.Scanner;

public class InputSanitizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String escapedInput = userInput.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(escapedInput);
    }
}