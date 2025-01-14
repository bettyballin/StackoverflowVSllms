import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.core.Point;
import org.opencv.core.MatOfPoint2f;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageAligner {
    static {
        // Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void align(String smallImagePath, String largeImagePath) {
        Mat smallImage = Imgcodecs.imread(smallImagePath);
        Mat largeImage = Imgcodecs.imread(largeImagePath);

        // Define the points (for example purposes)
        Point[] smallImagePoints = new Point[]{
            new Point(10, 20),
            new Point(30, 40),
            new Point(50, 60)
        };
        Point[] largeImagePoints = new Point[]{
            new Point(80, 90),
            new Point(100, 110),
            new Point(120, 130)
        };

        // Convert points to MatOfPoint2f
        MatOfPoint2f smallPts = new MatOfPoint2f(smallImagePoints);
        MatOfPoint2f largePts = new MatOfPoint2f(largeImagePoints);

        // Get the transformation matrix
        Mat transformMatrix = Imgproc.findHomography(smallPts, largePts);

        // Apply transformation
        Mat alignedImage = new Mat();
        Imgproc.warpPerspective(largeImage, alignedImage, transformMatrix,
                new Size(smallImage.cols(), smallImage.rows()));

        // Save the result
        Imgcodecs.imwrite("aligned_image.png", alignedImage);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ImageAligner [small-image-path] [large-image-path]");
        } else {
            align(args[0], args[1]);
            System.out.println("Image alignment complete. Check 'aligned_image.png'.");
        }
    }
}