import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Arrays.equals;

public class FastFileComparator {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException, NoSuchAlgorithmException {
        // List of files to compare
        File[] files = new File[1000000];

        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Submit tasks to generate checksums
        Future<byte[]>[] futures = new Future[files.length];
        for (int i = 0; i < files.length; i++) {
            futures[i] = executor.submit(new ChecksumTask(files[i]));
        }

        // Collect and compare hashes
        byte[][] hashes = new byte[files.length][];
        for (int i = 0; i < files.length; i++) {
            hashes[i] = futures[i].get();
        }
        executor.shutdown();

        // Compare hashes
        byte[] firstHash = hashes[0];
        for (int i = 1; i < files.length; i++) {
            if (!equals(firstHash, hashes[i])) {
                System.out.println("Files are not identical");
                return;
            }
        }
        System.out.println("Files are identical");
    }

    private static class ChecksumTask implements Callable<byte[]> {
        private final File file;

        public ChecksumTask(File file) {
            this.file = file;
        }

        @Override
        public byte[] call() throws IOException, NoSuchAlgorithmException {
            // Use a fast hash function
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // xxhash is not a standard Java algorithm
            FileInputStream fis = new FileInputStream(file);
            byte[] hash = md.digest(fis.readAllBytes());
            fis.close();
            return hash;
        }
    }
}