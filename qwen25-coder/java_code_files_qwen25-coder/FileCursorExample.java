import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

public class FileCursorExample {
    public static void main(String[] args) {
        File file = new File("path/to/your/largefile.xml");

        try (LineIterator it = FileUtils.lineIterator(file, "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                // Process your line here
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}