import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;

public class KeyboardVisibilityDetector extends Activity {
    private EditText editText;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize editText
        editText = new EditText(this);

        // Add a listener to detect when the keyboard is visible
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Check if the keyboard is visible
                int height = getWindow().getDecorView().getHeight();
                if (height < getWindowManager().getDefaultDisplay().getHeight()) {
                    // Keyboard is visible, adjust the layout
                    editText.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                } else {
                    // Keyboard is not visible, reset the layout
                    editText.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                }
            }
        });
    }

    public static void main(String[] args) {
    }
}