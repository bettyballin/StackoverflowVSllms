import java.lang.String;
import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        try {
            // Example of reading a file
            FileReader fileReader = new FileReader("example.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

            // Example of writing to a file
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello, world!");
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // Optional: for detailed stack trace
        }
    }
}