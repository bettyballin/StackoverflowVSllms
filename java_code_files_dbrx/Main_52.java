import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.io.*;
import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Path watchedDirectory = FileSystems.getDefault().getPath("path/to/the/csv/directory"); // set your csv directory here
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchedFileLogic wfl = new WatchedFileLogic(watcher, watchedDirectory);
            Thread t = new Thread(wfl);
            t.start(); // Start the thread for watching file changes
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}

class WatchedFileLogic implements Runnable {
    private WatchService watcher;
    private Path dir;

    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>) event;
    }

    /**
     * Creates a WatchService and registers the given directory with it.
     *
     * @param watcher
     * @param dir
     * @throws IOException if an I/O error occurs.
     */
    public WatchedFileLogic(WatchService watcher, Path dir) throws IOException {
        this.watcher = watcher;
        this.dir = dir;
        System.out.println("Initial Line Count: " + getLineCount()); // for testing purposes only
        dir.register(watcher, ENTRY_MODIFY);
    }

    @Override
    public void run() {
        while (true) {
            try {
                WatchKey key;
                try {
                    key = watcher.take(); // wait for a file change event from the OS
                } catch (InterruptedException ex) { // we can ignore it here
                    continue;
                }
                for (WatchEvent<?> event : key.pollEvents()) { // get list of events caused by single file change
                    WatchEvent<Path> ev = cast(event); // convert WatchEvent to proper type
                    Path filename = ev.context(); // get the filename from the path
                    int linesBeforeChange = getLineCount(); // get total number of lines prior to current file event
                    System.out.println("File: " + filename + ", changed at " + LocalDateTime.now());
                    if (!filename.toString().endsWith(".csv"))
                        continue; // skip other files
                    int newLineCount = ev.count(); // get the event count to represent the number of lines added for this file change event only
                    for (int i = 0; i < newLineCount; ++i) { // iterate over each line appended and process it accordingly
                        String newCsvRow = readLatestLineFromFile(); // read the latest line from the file
                        // Process the newCsvRow as needed
                    }
                    int linesAfterChange = getLineCount(); // get total number of file lines after change
                    assert linesBeforeChange + newLineCount == linesAfterChange; // verify we have accounted for all new lines added since last check (or an error occurred)
                    System.out.println("New Line Count: " + (linesAfterChange - linesBeforeChange)); // for testing purposes only
                }
                key.reset();
            } catch (Exception e) { // handle all exceptions
                System.out.print("Error Occurred: " + e); // print the reason for this exception so as not to miss it and move on...
            }
        }
    }

    private int getLineCount() {
        // Implement logic to return the total number of lines in the CSV file
        // For now, return a placeholder value
        return 0;
    }

    private String readLatestLineFromFile() {
        // Implement logic to read the latest line from the CSV file
        // For now, return a placeholder value
        return "";
    }
}