import java.util.Scanner;

public class SQLConsoleReader {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        
        String input;
        
        do {
            System.out.println("sql> ");
            input = scanner.next();
            
            if (!"".equals(input))
                sb.append(input).append(' '); //<--- This will add a space after each input.
            
            if (sb.toString().trim().endsWith(";")) { /* run query */ }
        } while (!"exit".equalsIgnoreCase(input));
    }
}