import java.lang.String;
// Import necessary classes
import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

public class WebcamCapture {

    static {
        // Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // Create an object to capture video from the webcam
        VideoCapture camera = new VideoCapture(0); // 0 usually indicates the default camera

        if (!camera.isOpened()) {
            System.out.println("Error: Could not open the connection to the webcam.");
            return;
        }

        org.opencv.core.Mat frame = new org.opencv.core.Mat();

        // Capture a single frame from the camera
        camera.read(frame);

        if (frame.empty()) {
            System.out.println("Failed to capture image");
        } else {
            String filename = "snapshot.jpg";
            Imgcodecs.imwrite(filename, frame);
            System.out.println("Image saved as " + filename);
        }

        // Release the camera and close all windows
        camera.release();
    }
}