import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main_278 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        // Make sure file path is provided as a command-line argument.
        if (args.length != 1) {
            System.out.println("Usage: java Main <file_path>");
            return;
        }

        String note = args[0];
        FileWriter fileWriter = new FileWriter(note, true); // append mode set to 'true'
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        fileWriter.write("\n" + name);
        fileWriter.flush(); // Writes remaining bytes to the underlying stream and flushes it.
        fileWriter.close(); // Closes file writer resource, releasing any system resources associated with this stream.
    }
}