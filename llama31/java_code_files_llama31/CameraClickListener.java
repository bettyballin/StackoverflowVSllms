/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraClickListener {
    public static void main(String[] stringArray) {
        CameraClickListener cameraClickListener = new CameraClickListener();
        cameraClickListener.simulateClick();
    }

    public void simulateClick() {
        String string = null;
        try {
            string = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File file = new File(System.getProperty("user.home"), string + ".jpg");
            System.out.println("File created: " + file.getAbsolutePath());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
