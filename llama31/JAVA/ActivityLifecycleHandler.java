import android.app.Activity;
import android.os.Bundle;

public class ActivityLifecycleHandler extends Activity {
    @Override
    protected void onPause() {
        super.onPause();
        // Avoid calling finish() here
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Clean up resources and close the activity if needed
        finish();
    }

    public static void main(String[] args) {}
}