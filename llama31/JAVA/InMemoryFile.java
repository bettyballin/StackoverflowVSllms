import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InMemoryFile extends File {
    private byte[] data;

    public InMemoryFile(byte[] data) {
        super("in-memory-file"); // a dummy file name
        this.data = data;
    }

    public FileInputStream getInputStream() throws IOException {
        return new FileInputStream(new ByteArrayInputStream(data));
    }

    public FileOutputStream getOutputStream() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        return new FileOutputStream(bos);
    }

    @Override
    public boolean exists() {
        return true; // always exists in memory
    }

    @Override
    public long length() {
        return data.length;
    }

    public static void main(String[] args) {
    }
}