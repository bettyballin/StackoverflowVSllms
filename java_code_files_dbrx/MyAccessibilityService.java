import androidx.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends androidx.accessibilityservice.AccessibilityService {
    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    public static void main(String[] args) {
    }
}