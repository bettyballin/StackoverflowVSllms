import java.lang.String;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class TailFileReader extends Reader {
    private static final int SLEEP_TIME = 1000; // 1 second
    private final File file;
    private RandomAccessFile raf;
    private final byte[] buffer = new byte[1024];
    private int bufferPosition;
    private int bufferLength;

    public TailFileReader(String filename) throws FileNotFoundException {
        this.file = new File(filename);
        this.raf = new RandomAccessFile(file, "r");
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (bufferLength == -1) {
            return -1; // EOF
        }

        if (bufferPosition == bufferLength) {
            // Buffer is empty, read new data
            bufferLength = raf.read(buffer);
            bufferPosition = 0;
            if (bufferLength == -1) {
                // EOF, wait for new data
                while (bufferLength == -1) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    // Check if file has been modified
                    if (file.lastModified() > raf.length()) {
                        // File has been modified, seek to the end and try reading again
                        raf.seek(raf.length());
                        bufferLength = raf.read(buffer);
                    }
                }
                bufferPosition = 0;
            }
        }

        // Convert bytes to chars
        int charsRead = 0;
        while (bufferPosition < bufferLength && charsRead < len) {
            cbuf[off + charsRead++] = (char) buffer[bufferPosition++];
        }
        return charsRead;
    }

    @Override
    public void close() throws IOException {
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        TailFileReader lft = new TailFileReader("application.log");
        BufferedReader br = new BufferedReader(lft);
        String line;
        while (true) {
            line = br.readLine();
            if (line == null) break;
            // Do something interesting with line
            System.out.println(line);
        }
    }
}