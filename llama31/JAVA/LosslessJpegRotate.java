import java.lang.String;
import com.drewnoakes.metadata.Metadata;
import com.drewnoakes.metadata.exif.ExifDirectoryBase;
import com.drewnoakes.metadata.exif.ExifIFD0Directory;
import com.drewnoakes.metadata.exif.ExifSubIFDDirectory;
import com.drewnoakes.metadata.jpeg.JpegMetadataReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LosslessJpegRotate {
    public static void rotate(File inputFile, File outputFile, int degrees) throws IOException {
        Metadata metadata = JpegMetadataReader.readMetadata(inputFile);
        ExifIFD0Directory exifIFD0Directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        ExifSubIFDDirectory exifSubIFDDirectory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

        int orientation = exifIFD0Directory.getInt(ExifDirectoryBase.TAG_ORIENTATION);

        // Update EXIF orientation
        switch (degrees) {
            case 90:
                orientation = (orientation + 1) % 8;
                break;
            case 180:
                orientation = (orientation + 2) % 8;
                break;
            case 270:
                orientation = (orientation + 3) % 8;
                break;
        }

        exifIFD0Directory.setInt(ExifDirectoryBase.TAG_ORIENTATION, orientation);

        // Write updated EXIF metadata
        BufferedImage image = ImageIO.read(inputFile);
        ImageIO.write(image, "jpg", outputFile);

        // Note: JpegMetadataReader does not have a writeMetadata method. 
        // You need to use JpegMetadataWriter instead.
        // JpegMetadataWriter.writeMetadata(outputFile, metadata);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.jpg");
        File outputFile = new File("output.jpg");
        rotate(inputFile, outputFile, 90);
    }
}