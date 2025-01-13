import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main_235 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <filename>");
            System.exit(1);
        }

        String note = args[0];
        Scanner sc = new Scanner(System.in);

        try (FileWriter file = new FileWriter(note)) {
            System.out.println("Enter your name:");
            String name = sc.next();
            file.write(name);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}