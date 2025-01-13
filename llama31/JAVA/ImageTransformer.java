import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageTransformer {
    public static void main(String[] args) {
        // Load OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Load images
        Mat smallImage = Imgcodecs.imread("small_image.tiff");
        Mat largeImage = Imgcodecs.imread("large_image.tiff");

        // Define anchor points (replace with actual coordinates)
        Point[] smallPoints = new Point[] {
            new Point(10, 10),
            new Point(20, 20),
            new Point(30, 30)
        };

        Point[] largePoints = new Point[] {
            new Point(50, 50),
            new Point(100, 100),
            new Point(150, 150)
        };

        // Calculate affine transformation matrix
        Mat transformationMatrix = Imgproc.getAffineTransform(largePoints, smallPoints);

        // Apply transformation to large image
        Mat transformedImage = new Mat();
        Imgproc.warpAffine(largeImage, transformedImage, transformationMatrix, smallImage.size());

        // Save transformed image
        Imgcodecs.imwrite("transformed_image.tiff", transformedImage);
    }
}