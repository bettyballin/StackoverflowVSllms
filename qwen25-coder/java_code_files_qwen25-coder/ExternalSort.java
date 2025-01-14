import java.io.*;
import java.util.*;

public class ExternalSort {
    private static final int CHUNK_SIZE = 1024 * 1024; // Size of each chunk to read

    public static void main(String[] args) throws IOException {
        String inputFilePath = "input.txt"; // This would be replaced with your actual data source
        String outputFilePath = "sorted_output.txt";

        File inputFile = new File(inputFilePath);
        List<File> sortedFileList = sortChunksIntoFiles(inputFile);

        try (PrintWriter writer = new PrintWriter(outputFilePath)) {
            mergeSortedFiles(sortedFileList, writer);
        }
    }

    private static List<File> sortChunksIntoFiles(File file) throws IOException {
        List<File> files = new ArrayList<>();
        BufferedReader reader = null;

        try {
            String line;
            List<String> lines = new LinkedList<>();
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                lines.add(line);

                if (++counter % CHUNK_SIZE == 0) { // Sort and write to file
                    File tempFile = File.createTempFile("sorted_chunk-", ".txt");
                    files.add(tempFile);
                    Collections.sort(lines);
                    writeSortedLinesToFile(lines, new FileWriter(tempFile));
                    lines.clear(); // Clear the list for the next chunk
                }
            }

            if (!lines.isEmpty()) { // Write remaining lines if any
                File tempFile = File.createTempFile("sorted_chunk-", ".txt");
                files.add(tempFile);
                Collections.sort(lines);
                writeSortedLinesToFile(lines, new FileWriter(tempFile));
            }
        } finally {
            if (reader != null) reader.close();
        }

        return files;
    }

    private static void mergeSortedFiles(List<File> sortedFiles, PrintWriter writer) throws IOException {
        List<BufferedReader> readers = new ArrayList<>();
        PriorityQueue<StringFromFile> priorityQueue = new PriorityQueue<>(Comparator.comparing(StringFromFile::getLine));

        try {
            // Initialize the queue with the first line from each file
            for (File f : sortedFiles) {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                readers.add(reader);
                String line = reader.readLine();
                if (line != null) priorityQueue.offer(new StringFromFile(line, reader));
            }

            while (!priorityQueue.isEmpty()) { // Merge into the output file
                StringFromFile stringFromFile = priorityQueue.poll();
                writer.println(stringFromFile.line);

                String nextLine = stringFromFile.reader.readLine();
                if (nextLine != null) {
                    priorityQueue.offer(new StringFromFile(nextLine, stringFromFile.reader));
                }
            }

        } finally {
            for (BufferedReader reader : readers) {
                reader.close(); // Close all readers
            }
        }

        // Delete the temporary files as they are no longer needed
        sortedFiles.forEach(File::delete);
    }

    private static void writeSortedLinesToFile(List<String> lines, FileWriter writer) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    // Helper class to store the line along with its source BufferedReader
    private static class StringFromFile {
        private final String line;
        private final BufferedReader reader;

        public StringFromFile(String line, BufferedReader reader) {
            this.line = line;
            this.reader = reader;
        }

        public String getLine() {
            return line;
        }
    }
}