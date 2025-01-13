import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JPGHeaderReconstructorInputStream_1_1 extends InputStream {
    private final FileInputStream fileInputStream;
    private final byte[] reconstructedHeader;
    private int reconstructedHeaderIndex = 0;

    public JPGHeaderReconstructorInputStream_1(File file, byte[] originalHeader) throws IOException {
        fileInputStream = new FileInputStream(file);
        reconstructedHeader = originalHeader.clone(); // store the original header
    }

    @Override
    public int read() throws IOException {
        if (reconstructedHeaderIndex < reconstructedHeader.length) {
            if (reconstructedHeaderIndex >= 6 && reconstructedHeaderIndex < 10) {
                reconstructedHeader[reconstructedHeaderIndex] = (byte) (0xFF & (reconstructedHeaderIndex == 6 ? 0xD8 : 0xE0)); // restore magic signature
            }
            return reconstructedHeader[reconstructedHeaderIndex++] & 0xFF;
        } else {
            return fileInputStream.read();
        }
    }

    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }

    public static void main(String[] args) {
        try {
            File file = new File("test.jpg");
            FileInputStream originalFileInputStream = new FileInputStream(file);
            byte[] originalHeader = new byte[10];
            originalFileInputStream.read(originalHeader);
            originalFileInputStream.close();

            JPGHeaderReconstructorInputStream_1 reconstructor = new JPGHeaderReconstructorInputStream_1(file, originalHeader);
            int byteRead;
            while ((byteRead = reconstructor.read()) != -1) {
                System.out.print(byteRead + " ");
            }
            reconstructor.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}