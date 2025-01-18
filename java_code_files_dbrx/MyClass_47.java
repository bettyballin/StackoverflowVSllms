import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.*;

public class MyClass {

    // Using RandomAccessFile to create a sparse file on unix platforms
    private void createSparseFile(String filename, long totalSize) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            // Make sure it can't go wrong due to concurrency errors.
            FileLock lock = raf.getChannel().tryLock();
            if (lock == null) throw new IOException("Could not get sparse-file exclusivity.");

            try {
                // seek 1 byte before the end so that a regular "fileSize - 1" later will round up
                // to the intended total size instead of one less. This may be unnecessary for your use case.
                raf.seek(totalSize - 1);
                // Writing an extra byte ensures we allocate physical storage up to this point, on systems that don't support sparse files as effectively.
                raf.write((byte)0x5E);      // This could be any value. I chose a tilde (^).
            } finally {
                lock.release();   // Always release your locks!
            }
        }
    }

    // Using FileChannel to truncate an existing file, or create a new one and then truncate it.
    private void truncateFile(String filename, long totalSize) throws IOException {
        Path path = Paths.get(filename);  // NIO Path for the output file.

        if (Files.exists(path))   // If it already exists...
            Files.deleteIfExists(path);   // ...we'll delete and recreate rather than risking partial data loss due to truncation.

        try (FileChannel ch = FileChannel.open(path, CREATE_NEW, APPEND)) {  // Create or append if it exists already, but...
            // Truncate the channel to this size regardless of whether we opened or appended to avoid unpredictable behaviour due to concurrency with other writers.
            ch.truncate(totalSize);    // This is equivalent to Unix's `ftruncate()`.
        }
    }
}