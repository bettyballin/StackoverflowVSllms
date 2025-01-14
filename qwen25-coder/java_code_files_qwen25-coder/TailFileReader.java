import java.lang.String;
import java.io.*;
import java.nio.file.*;

public class TailFileReader extends Reader {

    private final RandomAccessFile reader;
    private final File file;

    public TailFileReader(String filename) throws FileNotFoundException {
        this.file = new File(filename);
        this.reader = new RandomAccessFile(file, "r");
        try {
            followFile();
        } catch (IOException e) {
            throw new RuntimeException("Error setting up tail", e);
        }
    }

    private void followFile() throws IOException {
        // Move to the end of file
        long length = reader.length();
        reader.seek(length);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        
        if (sb.length() == 0) {
            // No data available, wait for a moment
            try {
                Thread.sleep(100); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Thread interrupted", e);
            }
        }

        if (sb.length() > len) {
            sb.setLength(len);
        }

        String result = sb.toString();
        result.getChars(0, Math.min(result.length(), len), cbuf, off);

        return Math.min(len, result.length());
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    public static void main(String[] args) {
    }
}