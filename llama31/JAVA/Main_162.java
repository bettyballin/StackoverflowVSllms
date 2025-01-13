import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main_162 {
    public static void main(String[] args) throws Exception {
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
        }
    }

    private static boolean isSpecial(String line) {
        // Your logic to check if the line is special.
        return false;
    }

    private static String editLine(String line) {
        // Your logic to edit the line.
        return line;
    }
}