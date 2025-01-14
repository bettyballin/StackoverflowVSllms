import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadedFileCopy {
    private static final int NUM_THREADS = 4; // Number of threads

    public static void copyFile(String source, String destination) throws IOException {
        File srcFile = new File(source);
        long fileSize = srcFile.length();
        long chunkSize = fileSize / NUM_THREADS;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            final long startByte = i * chunkSize;
            final long endByte = (i == NUM_THREADS - 1) ? fileSize : startByte + chunkSize;

            Thread thread = new Thread(() -> {
                try (RandomAccessFile src = new RandomAccessFile(srcFile, "r");
                     FileOutputStream dest = new FileOutputStream(destination, true)) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    long toRead = endByte - startByte;
                    src.seek(startByte);

                    while (toRead > 0 && (bytesRead = src.read(buffer, 0, (int) Math.min(buffer.length, toRead))) != -1) {
                        dest.write(buffer, 0, bytesRead);
                        toRead -= bytesRead;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String source = "sourceFile.dat";
        String destination = "destinationFile.dat";

        try {
            copyFile(source, destination);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error during file copying: " + e.getMessage());
        }
    }
}