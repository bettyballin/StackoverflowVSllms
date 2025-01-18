import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SaveLoadSample {
    private static final Path AUTOCOMPLETE_DATA_FILE = Path.of("autocompleteData.txt");

    // Replace with your existing method to add new elements into the list
    public void addNewSuggestion(String str) throws IOException {
        List<String> suggestionsList = loadSavedSuggestions();

        suggestionsList.add(str);

        storeSavedSuggestions(suggestionsList);
    }

    private void storeSavedSuggestions(List<String> listToStore) throws IOException {
        try (FileWriter writer = new FileWriter(AUTOCOMPLETE_DATA_FILE.toString())) {
            for (String suggestion : listToStore) {
                writer.write(suggestion + System.lineSeparator());
            }
        } // file will be automatically closed when exiting this block.
    }

    private List<String> loadSavedSuggestions() throws IOException {
        if (!Files.exists(AUTOCOMPLETE_DATA_FILE)) {
            Files.createFile(AUTOCOMPLETE_DATA_FILE);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(AUTOCOMPLETE_DATA_FILE.toAbsolutePath().toString()))) {
            String line;
            List<String> suggestionsList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                suggestionsList.add(line);
            }
            return suggestionsList;
        } // file will be automatically closed when exiting this block.
    }

    public static void main(String[] args) {
    }
}