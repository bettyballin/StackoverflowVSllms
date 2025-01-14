import android.os.Build;
import android.text.Layout;
import android.widget.TextView;

public class TextJustificationHelper {
    public static void main(String[] args) {
        TextView textView = new TextView(null); // In a real Android app, provide a valid Context instead of null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
    }
}