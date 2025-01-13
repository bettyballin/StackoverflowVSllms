/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class JPGHeaderReconstructorInputStream
extends InputStream {
    private File file;
    private byte[] originalHeader;
    private FileInputStream fileInputStream;
    private int headerIndex = 0;

    public JPGHeaderReconstructorInputStream(File file, byte[] byArray) throws IOException {
        this.file = file;
        this.originalHeader = byArray;
        this.fileInputStream = new FileInputStream(file);
    }

    @Override
    public int read() throws IOException {
        if (this.headerIndex < this.originalHeader.length) {
            return this.originalHeader[this.headerIndex++];
        }
        return this.fileInputStream.read();
    }

    public static void main(String[] stringArray) throws IOException {
        File file = new File("path/to/broken_jpg.jpg");
        byte[] byArray = new byte[]{-1, -40, -1, -32};
        JPGHeaderReconstructorInputStream jPGHeaderReconstructorInputStream = new JPGHeaderReconstructorInputStream(file, byArray);
        BufferedImage bufferedImage = ImageIO.read(jPGHeaderReconstructorInputStream);
    }
}
