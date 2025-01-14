import java.lang.String;
import java.lang.Integer;
import java.io.*;

public class IndexCreator {
    public static void main(String[] args) {
        String sourceFilePath = "sourceFile.txt";
        String indexFilePath = "indexFile.idx";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(indexFilePath))) {

            String line;
            long currentAddress = 0;

            while ((line = reader.readLine()) != null) {
                // Assuming keys are integers at the start of lines.
                if (!line.isEmpty() && Character.isDigit(line.charAt(0))) {
                    int key = Integer.parseInt(line.split(",")[0]);
                    writer.write(key + "\t" + Long.toHexString(currentAddress));
                    writer.newLine();
                }
                currentAddress += line.getBytes().length + 1; // +1 for the newline character
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}