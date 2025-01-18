import java.io.*;
import java.util.ArrayList;
import com.opencsv.CSVReader; // For CSVReader
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;

public class PhonebookEntryList extends ArrayList<PhonebookEntry> {
    public PhonebookEntryList(String filename) throws IOException {
        loadListFromFilename(filename);
    }

    private void loadListFromFilename(String inFile) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(inFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                PhonebookEntry entry = convertLineToPhoneBookEntry(line); // Implement this method
                add(entry);
            }
        } catch (IOException e){
          throw new IOException("Failed to load from " + inFile, e);
        }
    }

    private PhonebookEntry convertLineToPhoneBookEntry(String[] line) {
        // For simplicity, assuming line[0] is name, line[1] is phone number
        if (line.length >= 2) {
            return new PhonebookEntry(line[0], line[1]);
        } else {
            return null; // Or throw an exception
        }
    }

    public void saveListToFilename(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        try(CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)){
            forEach(csvPrinter::printRecord); // Each object needs to have a toString method implementing the desired output format. This is just writing objects content as csv values separated by commas in a file
        }catch (IOException e){
          throw new IOException("Failed to save to " + filename, e);
        }
    }

	public static void main(String[] args) {
	}
}

// Define PhonebookEntry class

class PhonebookEntry {
    private String name;
    private String phoneNumber;

    public PhonebookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Implement toString for CSV output
    @Override
    public String toString() {
        return name + "," + phoneNumber;
    }
}