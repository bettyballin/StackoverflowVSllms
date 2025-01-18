import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class FileProcessor_2 {

    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter p = null;
        try {
            in = new BufferedReader(new FileReader("in.txt"));
            FileOutputStream out = new FileOutputStream("out.txt");
            p = new PrintWriter(out);

            String line;
            while ((line = in.readLine()) != null) // Reads AND checks the line at same time.
            {
                if (specialCondition(line)) { // replace your special condition check here
                    String edited_line = doEdits(line); // Replace this with actual editing function.
                    p.println(edited_line);
                } else {
                    p.println(line);
                }
            }
        } catch (IOException ex) { // Catch exceptions that might occur due to file errors.
            System.err.print("Error during file processing");
        } finally {
            try {
                if (in != null) {
                    in.close(); // Don't forget to close the reader when you are done!
                }
            } catch (IOException e) {
                // Handle exception during close
            }
            if (p != null) {
                p.flush();  // Force everything out of the buffer right away.
                p.close();  // Don’t forget this one either, or things might linger.
            }
        }
    }

    private static boolean specialCondition(String line) {
        // replace your special condition check here
        return false;
    }

    private static String doEdits(String line) {
        // Replace this with actual editing function.
        return line;
    }
}