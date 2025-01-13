import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultithreadedFileCopy {
    public static void copyFile(String src, String tgt, int numThreads) throws IOException {
        // Open source and target files
        FileInputStream srcFile = new FileInputStream(src);
        FileOutputStream tgtFile = new FileOutputStream(tgt);

        // Calculate the chunk size for each thread
        long fileSize = srcFile.getChannel().size();
        long chunkSize = fileSize / numThreads;

        // Create and start threads
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            long start = i * chunkSize;
            long end = (i == numThreads - 1) ? fileSize : (i + 1) * chunkSize;
            threads[i] = new CopyThread(srcFile, tgtFile, start, end);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Close files
        srcFile.close();
        tgtFile.close();
    }

    private static class CopyThread extends Thread {
        private FileInputStream srcFile;
        private FileOutputStream tgtFile;
        private long start;
        private long end;

        public CopyThread(FileInputStream srcFile, FileOutputStream tgtFile, long start, long end) {
            this.srcFile = srcFile;
            this.tgtFile = tgtFile;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                // Seek to the start position
                srcFile.getChannel().position(start);

                // Copy the chunk
                byte[] buffer = new byte[4096];
                while (start < end) {
                    int bytesRead = srcFile.read(buffer);
                    if (bytesRead == -1) {
                        break;
                    }
                    tgtFile.write(buffer, 0, bytesRead);
                    start += bytesRead;
                }
            } catch (IOException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        try {
            copyFile("source.txt", "target.txt", 4);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}