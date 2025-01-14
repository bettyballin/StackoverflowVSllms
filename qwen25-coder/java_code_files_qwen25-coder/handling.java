import java.io.*;

public class handling {
    // Assume DataStore is a class handling file operations
    class DataStore {
        private File logFile;
        private File dataFile;
    
        public DataStore(String dataFilePath, String logFilePath) throws IOException {
            this.dataFile = new File(dataFilePath);
            this.logFile = new File(logFilePath);
        }
    
        public void writeDataWithTransaction(byte[] data) throws IOException {
            // Write to the transaction log first
            try (RandomAccessFile logRAF = new RandomAccessFile(logFile, "rw")) {
                long position = logRAF.length();
                logRAF.seek(position);
                logRAF.writeInt(data.length); // Store length of data for read recovery
                logRAF.write(data);          // Write data to log
            }
    
            // Now perform actual write to the data file
            writeDataToFile(data);
    
            // Log is now obsolete, truncate the log
            try (RandomAccessFile logRAF = new RandomAccessFile(logFile, "rw")) {
                logRAF.setLength(0);
            }
        }
    
        private void writeDataToFile(byte[] data) throws IOException {
            // Actual logic to write to data file safely in an atomic manner if possible.
            // For example, write the data to the dataFile here.
        }
    
        public byte[] recoverFromLog() throws IOException {
            if (logFile.length() == 0) return null;
    
            try (RandomAccessFile logRAF = new RandomAccessFile(logFile, "rw")) {
                int size = logRAF.readInt(); // Read size of the data to recover
                byte[] buffer = new byte[size];
                int bytesRead = logRAF.read(buffer);
                if (bytesRead != size) throw new IOException("Incomplete transaction log found.");
                
                writeDataToFile(buffer);       // Apply the changes from log to main storage
                return buffer;                 // Return recovered data
            }
        }
    }

    public static void main(String[] args) {
        // Example usage of DataStore
        // DataStore store = new handling().new DataStore("data.dat", "log.dat");
        // Add code here to test DataStore methods if necessary.
    }
}