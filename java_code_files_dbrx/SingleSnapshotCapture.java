import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

public class SingleSnapshotCapture {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        int cameraIndex = 0; // The index of your camera (usually, 0 should be your default webcam)
        VideoCapture capture = new VideoCapture(cameraIndex);
        if (!capture.isOpened()) {
            System.out.println("Error: Could not open video input device.");
        } else {
            Mat frame = new Mat(); // Matrix to hold the snapshot image
            while (true) { // Capture frames in a loop
                capture.read(frame); // Read from webcam into 'frame' matrix
                if (!frame.empty()) { // If camera is still working...
                    String fileName = "snapshot-" + System.currentTimeMillis() + ".png";
                    Imgcodecs.imwrite(fileName, frame); // Save image to file
                    break; // Exit the loop after capturing one frame (single snapshot)
                } else {
                    System.out.println("Error: Could not read from webcam.");
                    break;
                }
            }
        }
    }
}