import java.lang.String;
import java.io.Console;

public class Main_295 {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            String input = new String(console.readPassword("Enter command: "));
            System.out.println("Output of command goes here");
        } else {
            System.out.println("Console not available");
        }
    }
}