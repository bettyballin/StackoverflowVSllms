import java.lang.String;

// Example in Java
public class CameraController {
    private CameraModel model;
    private CameraDevice camera;

    public CameraController(CameraModel model, CameraDevice camera) {
        this.model = model;
        this.camera = camera;
    }

    public void pollCamera() {
        byte[] imageData = camera.pollData();
        model.updateImage(imageData);
    }

    public static void main(String[] args) {
        // You can instantiate and test the CameraController here if needed
    }
}

class CameraModel {
    public void updateImage(byte[] imageData) {
        // Method stub
    }
}

class CameraDevice {
    public byte[] pollData() {
        return new byte[0]; // Return an empty byte array
    }
}