import java.lang.String;
import java.io.*;
import java.util.Scanner;

public class Main_277 {
    public static void main(String[] args) throws IOException {
        String note = "text.txt";
        FileWriter fileWriter = new FileWriter(note, true); // Append mode set to 'true'
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        fileWriter.write("\n" + name);
        fileWriter.flush(); // Writes remaining bytes to the underlying stream and flushes it.
        fileWriter.close(); // Closes file writer resource, releasing any system resources associated with this stream.
    }
}