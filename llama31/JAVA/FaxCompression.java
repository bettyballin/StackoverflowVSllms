import java.lang.String;
import java.util.Scanner;

public class FaxCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = scanner.nextLine();
        scanner.close();

        compress(input);
    }

    public static void compress(String input) {
        StringBuilder output = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                output.append(count).append(":").append(currentChar).append(" ");
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        output.append(count).append(":").append(currentChar);
        System.out.println(output.toString());
    }
}