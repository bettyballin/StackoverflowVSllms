import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.RationalNumber;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;

public class JpegValidator {
    public static boolean validateJpegFile(String filePath) {
        try {
            JpegImageMetadata metadata = Imaging.getMetadata(filePath, JpegImageMetadata.class);
            RationalNumber[] dimensions = metadata.getJpegDimension();
            return dimensions != null && dimensions.length == 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateJpegFile("path_to_your_jpeg_file.jpg"));
    }
}