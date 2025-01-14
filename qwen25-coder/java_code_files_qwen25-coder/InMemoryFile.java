import java.lang.String;
import java.io.*;

public class InMemoryFile {
    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bais;

    public InMemoryFile() {
        baos = new ByteArrayOutputStream();
    }

    // Method to write data as if it were writing to a file
    public void writeFile(byte[] bytes) throws IOException {
        baos.write(bytes);
        bais = null; // invalidate the input stream if necessary
    }

    // Method to read data as if it were reading from a file
    public byte[] readFile() {
        if (bais == null) {
            bais = new ByteArrayInputStream(baos.toByteArray());
        }
        return bais.readAllBytes();
    }

    // You can create additional methods like write, readLine, etc., based on your needs

	public static void main(String[] args) {
	}
}