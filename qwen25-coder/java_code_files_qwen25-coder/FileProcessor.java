import java.lang.String;
import java.io.*;
public class FileProcessor {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter p = null;

        try {
            in = new BufferedReader(new FileReader("in.txt"));
            FileOutputStream out = new FileOutputStream("out.txt");
            p = new PrintWriter(out, true); // 'true' enables auto-flush

            String line;
            while ((line = in.readLine()) != null) {
                if (isSpecial(line)) {  // replace with actual condition
                    p.println(editLine(line)); // replace with actual editing logic
                } else {
                    p.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.close(); // close to flush and release resources
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isSpecial(String line) {
        return line.contains("special_keyword"); // Example condition
    }

    private static String editLine(String line) {
        return line.replace("old", "new"); // Example editing logic
    }
}