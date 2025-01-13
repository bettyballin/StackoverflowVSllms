import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;

public class Main_286 extends Activity {
    public static void main(String[] args) {
        // Enable/disable auto sync
        ContentResolver.setMasterSyncAutomatically(true); // enable auto sync
        ContentResolver.setMasterSyncAutomatically(false); // disable auto sync

        // Enable/disable background data
        ConnectivityManager cm = (ConnectivityManager) new Main().getSystemService(Context.CONNECTIVITY_SERVICE);
        cm.setBackgroundDataSetting(true); // enable background data
        cm.setBackgroundDataSetting(false); // disable background data
    }
}