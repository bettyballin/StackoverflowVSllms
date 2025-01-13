import java.io.FileOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codecimpl.TIFFImageEncoder;

public class JpegToTiffConverter {
    public static void convertJpegToTiff(String jpegFilePath, String tiffFilePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(jpegFilePath));

        TIFFEncodeParam params = new TIFFEncodeParam();
        params.setCompression(TIFFEncodeParam.COMPRESSION_DEFLATE);

        OutputStream outputStream = new FileOutputStream(tiffFilePath);
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);

        ImageWriter writer = ImageIO.getImageWritersByFormatName("tiff").next();
        writer.setOutput(imageOutputStream);
        writer.write(bufferedImage);
        writer.dispose();

        imageOutputStream.close();
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        convertJpegToTiff("input.jpg", "output.tiff");
    }
}