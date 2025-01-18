import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Register receiver within the activity's lifecycle methods, e.g., onCreate() or onStart():
        LocalBroadcastManager.getInstance(this).registerReceiver(myResultReceiver, new IntentFilter("action_get_result"));
        
        // In your service's thread, send a message like this after processing is completed or intermediary updates are needed:
        Intent intent = new Intent("action_get_result");
        intent.putExtra("resultCode", 1);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
    
    private BroadcastReceiver myResultReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Extract result or messages from intent.
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                int resultCode = bundle.getInt("resultCode");
                // TODO: Handle your results accordingly.
            }
        }
    };
}