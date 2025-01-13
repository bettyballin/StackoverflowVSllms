import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWriterHelper_1_1 {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("example.txt"));
            writer.println("Hello, World!");
            if (writer.checkError()) {
                System.out.println("An error occurred while writing to the file.");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}