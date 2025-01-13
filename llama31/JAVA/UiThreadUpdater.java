import android.os.Handler;
import android.os.Looper;

public class UiThreadUpdater {
    public UiThreadUpdater() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Update the UI
            }
        });
    }

    public static void main(String[] args) {
        new UiThreadUpdater();
    }
}