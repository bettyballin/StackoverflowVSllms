import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageEnhancement {
    public static void main(String[] args) {
        // Load the OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Load the image
        Mat image = Imgcodecs.imread("input_image.jpg");

        // Deskew the image
        Mat deskewedImage = new Mat();
        Imgproc.deskew(image, deskewedImage);

        // Remove lines
        Mat lineRemovedImage = new Mat();
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new org.opencv.core.Size(3, 3));
        Imgproc.morphologyEx(deskewedImage, lineRemovedImage, Imgproc.MORPH_OPEN, kernel);

        // Sharpen the image
        Mat sharpenedImage = new Mat();
        Mat sharpeningKernel = new Mat(3, 3, org.opencv.core.CvType.CV_8SC1);
        sharpeningKernel.put(0, 0, 0);
        sharpeningKernel.put(0, 1, -1);
        sharpeningKernel.put(0, 2, 0);
        sharpeningKernel.put(1, 0, -1);
        sharpeningKernel.put(1, 1, 5);
        sharpeningKernel.put(1, 2, -1);
        sharpeningKernel.put(2, 0, 0);
        sharpeningKernel.put(2, 1, -1);
        sharpeningKernel.put(2, 2, 0);
        Imgproc.filter2D(lineRemovedImage, sharpenedImage, -1, sharpeningKernel);

        // Save the enhanced image
        Imgcodecs.imwrite("output_image.jpg", sharpenedImage);
    }
}