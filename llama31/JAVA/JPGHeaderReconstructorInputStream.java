import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class JPGHeaderReconstructorInputStream extends InputStream {
    private File file;
    private byte[] originalHeader;
    private FileInputStream fileInputStream;
    private int headerIndex = 0;

    public JPGHeaderReconstructorInputStream(File file, byte[] originalHeader) throws IOException {
        this.file = file;
        this.originalHeader = originalHeader;
        this.fileInputStream = new FileInputStream(file);
    }

    @Override
    public int read() throws IOException {
        if (headerIndex < originalHeader.length) {
            return originalHeader[headerIndex++];
        } else {
            return fileInputStream.read();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("path/to/broken_jpg.jpg");
        byte[] originalHeader = new byte[] { (byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE0 }; // store the original header

        JPGHeaderReconstructorInputStream reconstructedInputStream = new JPGHeaderReconstructorInputStream(file, originalHeader);

        // Use the reconstructed input stream to load the image
        BufferedImage image = ImageIO.read(reconstructedInputStream);
    }
}