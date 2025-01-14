import java.lang.String;
// Example in Java
public class CameraModel {
    private byte[] imageData;

    public void startPolling(CameraDevice camera) {
        // Polling logic managed by the model
        imageData = camera.pollData();
        notifyObservers();  // Inform view of change
    }

    private void notifyObservers() {
        // Notify registered views or other entities about data update
    }
}

class CameraDevice {
    public byte[] pollData() {
        // Simulate polling data from camera
        return new byte[0];
    }
}

public class Main {
    public static void main(String[] args) {
        CameraDevice camera = new CameraDevice();
        CameraModel model = new CameraModel();
        model.startPolling(camera);
    }
}