import android.content.Intent;
import android.app.Activity;

public class Broadcaster extends Activity {
    public void broadcastIntent() {
        Intent intent = new Intent("com.example.MY_INTENT");
        sendBroadcast(intent);
    }

    public static void main(String[] args) {
    }
}