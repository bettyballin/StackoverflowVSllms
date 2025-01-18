// ART-based app example with AOT compiler
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public class MyActivity extends Activity {

    static {
        System.loadLibrary("art");
    }

    public native void init(String abc);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform AOT compilation here
        String abc = "aot-compiled code";
        init(abc);
    }

}