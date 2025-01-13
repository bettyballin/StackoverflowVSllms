import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Uniq {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Uniq <filename>");
            return;
        }

        String filename = args[0];
        Set<String> seen = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\s+");
                if (fields.length > 0 && seen.add(fields[0])) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}