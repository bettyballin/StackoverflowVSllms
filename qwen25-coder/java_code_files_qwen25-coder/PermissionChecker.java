import java.lang.String;
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionChecker extends Activity {

    private static final int MY_PERMISSIONS_REQUEST_READ_SMS = 0;

    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_SMS},
                    MY_PERMISSIONS_REQUEST_READ_SMS);
        }
    }

    public static void main(String[] args) {
    }
}