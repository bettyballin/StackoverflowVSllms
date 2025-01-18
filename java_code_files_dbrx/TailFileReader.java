import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.util.*;

public class TailFileReader implements Closeable {
    private final Path path;
    private final WatchService watcher;
    private long lastSkipBytesOffset = 0L; // Used to track the current position in a rolling file scenario
    private RandomAccessFile raf;
    private boolean closed = false;

    public TailFileReader(Path fileName) throws IOException {
        this.path = fileName;
        watcher = FileSystems.getDefault().newWatchService(); // Watches for file changes like new lines added

        try (InputStream inputStream = Files.newInputStream(fileName)) {
            raf = new RandomAccessFile(path.toAbsolutePath().toString(), "rw"); // Use a random access file to jump around the seek position
            long skipBytes = findLastOffset(); // Jumps to last line added in the case of restarting/reloading
            if (skipBytes > 0) {
                inputStream.skip(skipBytes); // Skip any remaining bytes that aren't end-of files
                raf.seek(raf.length());
                return;
            }
        } catch (IOException e) {
            System.out.println("Error initializing TailFileReader: " + e.getMessage());
        }
    }

    private long findLastOffset() throws IOException {
        // Implement logic to find last offset
        // For now, return 0L
        return 0L;
    }

    @Override
    public void close() throws IOException {
        closed = true;
        if (raf != null) {
            raf.close();
        }
        if (watcher != null) {
            watcher.close();
        }
    }

    // To be called once per line to read a line from the file
    public String getNextLine() throws IOException {
        if (closed) throw new IOException("TailFileReader is already closed.");

        WatchKey key;
        try {
            // Block and wait for a change in filesystem
            key = watcher.take();
        } catch (InterruptedException e) {
            return null;
        }

        ArrayList<WatchEvent<?>> events = new ArrayList<>();

        // Iterate through the found file events and look for ones that are related to the logfile
        for (final WatchEvent<?> event : key.pollEvents()) {
            if (event.kind() == ENTRY_MODIFY && Objects.equals(((Path) event.context()).toString(), path.getFileName().toString())) {
                events.add((WatchEvent<Object>) event);
            }
        }

        // If there were no events, bail out
        if (events.isEmpty()) return null;
        System.out.println("File " + key.watchable() + " modified.");

        /* Seek to the last position in file and read line */
        raf.seek(lastSkipBytesOffset); // Jump to the end of existing content
        String newLine = raf.readLine();
        if (newLine != null) {
            lastSkipBytesOffset = raf.getFilePointer(); // Save current position as seek point for next line
            return newLine;
        } else {
            return null;
        }
    }
}