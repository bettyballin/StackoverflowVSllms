import java.io.*;
import java.util.*;

public class PhonebookEntryList {
    private List<PhonebookEntry> entries;

    public PhonebookEntryList(String filename) throws IOException {
        entries = new ArrayList<>();
        loadListFromFilename(filename);
    }

    private void loadListFromFilename(String filename) throws IOException {
        // Implement logic to read from file and populate 'entries'
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line is a PhonebookEntry, adjust parsing as necessary
                entries.add(new PhonebookEntry(line));
            }
        }
    }

    public void saveListToFilename(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (PhonebookEntry entry : entries) {
                // Write each entry to a file, adjust format as necessary
                writer.write(entry.toString());
                writer.newLine();
            }
        }
    }

    // Additional methods to manipulate the list can be added here

    public static void main(String[] args) {
        // Example usage
        try {
            PhonebookEntryList pbList = new PhonebookEntryList("input.txt");
            pbList.saveListToFilename("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PhonebookEntry {
    private String data;

    public PhonebookEntry(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}