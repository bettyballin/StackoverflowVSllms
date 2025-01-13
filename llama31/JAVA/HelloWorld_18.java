import java.lang.String;
// Android SDK example
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorld_18 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Hello, World!");
        setContentView(textView);
    }

	public static void main(String[] args) {
	}
}