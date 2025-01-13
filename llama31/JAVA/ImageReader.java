import com.drew.imaging.ImageMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.GpsDirectory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageReader {
    public static void main(String[] args) throws IOException, MetadataException {
        // Example: Load image bytes from a file for demonstration.
        // In a real scenario, replace this with your actual source of image bytes.
        byte[] imageBytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("path/to/your/image.jpg"));
        
        Metadata metadata = ImageMetadataReader.readMetadata(new ByteArrayInputStream(imageBytes));
        GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
        
        if (gpsDirectory != null) {
            GeoLocation geoLocation = gpsDirectory.getGeoLocation();
            if (geoLocation != null) {
                System.out.println("Image location: " + geoLocation);
            } else {
                System.out.println("No location data found in the image.");
            }
        } else {
            System.out.println("No GPS directory found in the image metadata.");
        }

        // Now you can use ImageIO to read the image
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
        // Process the image as needed
        System.out.println("Image loaded: " + image.getWidth() + "x" + image.getHeight());
    }
}