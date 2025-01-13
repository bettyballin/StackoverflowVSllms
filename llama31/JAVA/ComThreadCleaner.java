import java.lang.String;

public class ComThreadCleaner {
    public static void main(String[] args) {
        // Initialize COM thread
        ComThread.InitMTA(true);

        // ... use COM objects ...

        // Release COM objects
        for (ComObject obj : comObjects) {
            obj.SafeRelease();
        }

        // Release COM apartment thread
        ComThread.Release();

        // Call the following method to ensure native resources are released
        ComThread.quitMTA();
    }
}