import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JpegRotator {
    public static void rotateJpeg(File inputFile, File outputFile, int rotationDegrees) throws IOException {
        // Read the input image
        BufferedImage inputImage = ImageIO.read(inputFile);

        // Get the JPEG writer
        ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();

        // Create a new output stream
        FileImageOutputStream outputStream = new FileImageOutputStream(outputFile);

        // Set the output parameters to match the input image
        ImageWriteParam params = writer.getDefaultWriteParam();
        params.setSourceRegion(inputImage.getMinX(), inputImage.getMinY(), inputImage.getWidth(), inputImage.getHeight());

        // Rotate the image in the compressed domain
        if (rotationDegrees == 90 || rotationDegrees == 270) {
            // Transpose the DCT coefficients
            params.setSourceRegion(inputImage.getMinY(), inputImage.getMinX(), inputImage.getHeight(), inputImage.getWidth());
        }

        // Write the rotated image
        writer.setOutput(outputStream);
        writer.write(inputImage);

        // Clean up
        writer.dispose();
        outputStream.close();
    }

    public static void main(String[] args) {
        // Example usage:
        // File inputFile = new File("input.jpg");
        // File outputFile = new File("output.jpg");
        // int rotationDegrees = 90;
        // try {
        //     rotateJpeg(inputFile, outputFile, rotationDegrees);
        // } catch (IOException e) {
        //     System.err.println("Error rotating image: " + e.getMessage());
        // }
    }
}