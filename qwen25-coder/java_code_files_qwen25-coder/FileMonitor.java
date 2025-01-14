import java.lang.String;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileMonitor {
    private final String filePath;
    private long lastPosition = 0;
    private RandomAccessFile fileRAF;

    public FileMonitor(String filePath) {
        this.filePath = filePath;
    }

    public void startMonitoring() {
        try {
            fileRAF = new RandomAccessFile(Paths.get(filePath).toFile(), "r");
            fileRAF.seek(fileRAF.length()); // Start reading from the end of the file
            lastPosition = fileRAF.getFilePointer();
            
            while (true) { // Replace with a proper stop condition in production code
                try {
                    String line;
                    while ((line = fileRAF.readLine()) != null) {
                        System.out.println("New line detected: " + line);
                        lastPosition = fileRAF.getFilePointer(); // Update the read position
                    }
                } catch (IOException e) {
                    // Handle reconnection or reinitialization on error
                    System.err.println("Error reading file. Reconnecting...");
                    reconnectToFile();
                }

                try {
                    Thread.sleep(1000); // Poll every second, adjust as needed for your use case
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } finally {
            try {
                if (fileRAF != null) {
                    fileRAF.close();
                }
            } catch (IOException ioe) {
                System.err.println("Error closing the file.");
            }
        }
    }

    private void reconnectToFile() {
        // Close and reopen the RandomAccessFile
        if (fileRAF != null) {
            try {
                fileRAF.close();
            } catch (IOException e) {
                System.err.println("Failed to close RAF: " + e.getMessage());
            }
        }
        
        while (true) {
            try {
                File file = Paths.get(filePath).toFile();
                if (!file.exists()) {
                    throw new FileNotFoundException("Waiting for the file to reappear.");
                }
                
                fileRAF = new RandomAccessFile(file, "r");
                fileRAF.seek(lastPosition); // Seek to where we last read
                break;
            } catch (FileNotFoundException | NoSuchFileException e) {
                System.err.println("Reconnect failed. Retrying...");
                try {
                    Thread.sleep(5000); // Wait 5 seconds before retrying, adjust as needed
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            } catch (IOException ioe) {
                System.err.println("IO Exception while reconnecting: " + ioe.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        FileMonitor monitor = new FileMonitor("/path/to/file.csv");
        monitor.startMonitoring();
    }
}