import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.hardware.Camera;
import android.content.Context;
import android.util.Log;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;

public class ImageCaptureCallback extends Activity {
    private Button imagecapture;
    private Camera camera;
    private Camera.ShutterCallback mShutterCallback = new Camera.ShutterCallback() {
        public void onShutter() {
            // Optional: Do something when the shutter closes
        }
    };
    private Camera.PictureCallback mPictureCallbackRaw = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            // Optional: Handle raw image data
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assuming we have a layout called activity_main
        setContentView(R.layout.activity_main);

        // Open the camera
        camera = Camera.open();

        imagecapture = (Button) findViewById(R.id.imagecapture);
        imagecapture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String filename = DateFormat.format("yyyyMMdd_hhmmss", new Date()).toString();
                String filePath = Environment.getExternalStorageDirectory().toString() + "/YourFolderName/" + filename + ".jpg";

                File dir = new File(Environment.getExternalStorageDirectory() + "/YourFolderName");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File imageFile = new File(filePath);

                try {
                    OutputStream outputStream = new FileOutputStream(imageFile);
                    MyImageCaptureCallback iccb = new MyImageCaptureCallback(outputStream);

                    camera.takePicture(mShutterCallback, mPictureCallbackRaw, iccb);
                    Park.imageFileName = filename + ".jpg";
                } catch (FileNotFoundException e) {
                    Log.e(getClass().getSimpleName(), "File not found: " + e.getMessage(), e);
                }
            }
        });
    }

    private class MyImageCaptureCallback implements Camera.PictureCallback {
        private OutputStream outputStream;

        public MyImageCaptureCallback(OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                outputStream.write(data);
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                Log.e(getClass().getSimpleName(), "Exception in photo callback: " + e.getMessage(), e);
            }

            // Restart the preview after taking a picture
            camera.startPreview();
        }
    }

    public static void main(String[] args) {
        // Entry point (not typically used in Android applications)
    }
}

// Placeholder class for 'Park'
class Park {
    public static String imageFileName;
}

// Placeholder class for 'R' resources
class R {
    public static class layout {
        public static int activity_main = 0x7f030000;
    }

    public static class id {
        public static int imagecapture = 0x7f040000;
    }
}