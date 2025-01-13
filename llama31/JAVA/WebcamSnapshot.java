import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class WebcamSnapshot {
    public static void main(String[] args) {
        // Load OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Create a new VideoCapture object
        VideoCapture capture = new VideoCapture(0); // 0 = default webcam

        // Check if the webcam is opened
        if (!capture.isOpened()) {
            System.out.println("Cannot open camera");
            return;
        }

        // Create a new Mat object to store the frame
        Mat frame = new Mat();

        // Capture a single frame from the webcam
        capture.read(frame);

        // Release the VideoCapture object
        capture.release();

        // Save the frame to a JPG file
        String filename = "snapshot.jpg";
        Imgcodecs.imwrite(filename, frame);

        System.out.println("Snapshot saved to " + filename);
    }
}