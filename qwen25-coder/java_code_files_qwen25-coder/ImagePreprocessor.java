import java.lang.String;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImagePreprocessor {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void preprocessImage(String imagePath, String outputPath) {
        // Read the image
        Mat src = Imgcodecs.imread(imagePath);
        
        if (src.empty()) {
            System.out.println("Could not open or find the image!");
            return;
        }
        
        // Convert to grayscale
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        // Apply adaptive thresholding for better contrast
        Mat thresh = new Mat();
        Imgproc.adaptiveThreshold(gray, thresh, 255,
                                  Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY,
                                  11, 2);
        
        // Optionally, apply Gaussian blur to reduce noise and improve text definition
        Mat blurred = new Mat();
        Imgproc.GaussianBlur(thresh, blurred, new Size(5, 5), 0);
        
        // Save the processed image
        Imgcodecs.imwrite(outputPath, blurred);
    }

    public static void main(String[] args) {
        preprocessImage("path_to_input_image.jpg", "path_to_output_image.jpg");
    }
}