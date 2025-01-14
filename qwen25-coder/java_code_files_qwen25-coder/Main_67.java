import java.lang.String;
import java.util.Scanner;

class PaddedStringBuilder {
    private StringBuilder sb;
    private String padString;

    public PaddedStringBuilder(String padString) {
        this.sb = new StringBuilder();
        this.padString = padString;
    }

    public PaddedStringBuilder append(Object obj) {
        if (sb.length() > 0) { // Avoid adding padding at the start
            sb.append(padString);
        }
        sb.append(obj);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

public class Main_67 {
    public static boolean empty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static void main(String[] args) {
        String input;
        PaddedStringBuilder query = new PaddedStringBuilder(" ");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("sql> ");
            input = scanner.nextLine();

            if (!empty(input)) {
                query.append(input);
            }

            if (query.toString().trim().endsWith(";")) {
                // run query
                System.out.println("Executing query: " + query.toString().trim());
                break; // For demonstration, execute and stop after a valid query
            }
        } while (!input.equalsIgnoreCase("exit"));

        scanner.close();
    }
}