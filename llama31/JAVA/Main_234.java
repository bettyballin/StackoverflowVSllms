import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main_234 {
    public static void main(String[] args) {
        String note = "text.txt";
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