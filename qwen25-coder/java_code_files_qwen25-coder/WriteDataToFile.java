import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToFile {
    public static void main(String[] args) {
        String filePath = "workout_data.txt";
        
        // Data to be written
        String[][] data = {
            {"Jessica", "Walking", "20 minutes"},
            {"Matthew", "Run", "10 minutes"}
        };
        
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (String[] record : data) {
                fileWriter.write(String.format("%-9s %-10s %s%n", record[0], record[1], record[2]));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}