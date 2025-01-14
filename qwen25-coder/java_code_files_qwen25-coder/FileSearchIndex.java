import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileSearchIndex {
    private Map<String, Set<String>> index = new HashMap<>();

    public void addToIndex(Path filePath) {
        String fileName = filePath.getFileName().toString();
        String filePathStr = filePath.toString();
        for (String token : tokenize(fileName)) {
            index.computeIfAbsent(token, k -> new HashSet<>()).add(filePathStr);
        }
    }

    public void saveIndex(String indexPath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(indexPath))) {
            oos.writeObject(index);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadIndex(String indexPath) throws IOException, ClassNotFoundException {
        File indexFile = new File(indexPath);
        if (indexFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(indexPath))) {
                index = (Map<String, Set<String>>) ois.readObject();
            }
        } else {
            System.out.println("Index file does not exist. Please create an index first.");
        }
    }

    public Set<String> search(String query) {
        String[] tokens = tokenize(query);
        if (tokens.length == 0) return Collections.emptySet();

        Set<String> results = new HashSet<>(index.getOrDefault(tokens[0], Set.of()));
        for (String token : Arrays.copyOfRange(tokens, 1, tokens.length)) {
            results.retainAll(index.getOrDefault(token, Set.of()));
        }
        return results;
    }

    private String[] tokenize(String input) {
        // Simple tokenizer based on whitespace and punctuation. You can enhance it.
        return input.toLowerCase().split("[\\W_]+");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileSearchIndex fileSearchIndex = new FileSearchIndex();

        // Example of adding files to the index
        fileSearchIndex.addToIndex(Paths.get("/home/username/suresh"));
        fileSearchIndex.addToIndex(Paths.get("/home/username/images/picture.jpg"));

        // Save index to disk
        fileSearchIndex.saveIndex("file_search_index.ser");

        // Load index from disk
        fileSearchIndex.loadIndex("file_search_index.ser");

        // Search for files
        Set<String> results = fileSearchIndex.search("suresh");
        System.out.println("Files found: " + results);
    }
}