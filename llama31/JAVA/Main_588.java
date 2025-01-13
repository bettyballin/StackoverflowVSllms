import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main_588 {
    public static void main(String[] args) {
        try {
            // Writing a file
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Name,Address,Phone\n");
            writer.write("John Doe,123 Main St,123-456-7890\n");
            writer.close();

            // Reading a record from a file
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                System.out.println("Name: " + record[0]);
                System.out.println("Address: " + record[1]);
                if(record.length > 2) {
                    System.out.println("Phone: " + record[2]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the file.");
        }
    }
}