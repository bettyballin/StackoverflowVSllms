import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TextStyler extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_styler);

        Button button = findViewById(R.id.button);
        SpannableStringBuilder sb = new SpannableStringBuilder("Hello World");
        sb.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sb.setSpan(new StyleSpan(Typeface.ITALIC), 6, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        button.setText(sb);
    }

    public static void main(String[] args) {
        // This main method is not required in Android applications
    }
}