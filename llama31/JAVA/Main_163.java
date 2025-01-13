import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main_163 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("in.txt"));
             PrintWriter p = new PrintWriter(new FileOutputStream("out.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (isSpecial(line)) {
                    String editedLine = editLine(line);
                    p.println(editedLine);
                } else {
                    p.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // You need to implement these methods according to your logic
    private static boolean isSpecial(String line) {
        // implement your logic to check if the line is special
        return false;
    }

    private static String editLine(String line) {
        // implement your logic to edit the line
        return line;
    }
}