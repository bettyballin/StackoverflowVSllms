import java.io.Console;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console cnsl = System.console();
        if (cnsl != null) {
            char ch = (char) cnsl.reader().read(); // read a single character from the console
            // ...                             // process or print the character as needed
        } else {
            System.out.println("Console not available.");
        }
    }
}