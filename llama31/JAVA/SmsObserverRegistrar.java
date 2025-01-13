import java.lang.String;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;

public class SmsObserverRegistrar {
    private Context context;

    public SmsObserverRegistrar(Context context) {
        this.context = context;
        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.registerContentObserver(Uri.parse("content://sms/sent"), true, new SmsSentObserver(new Handler()));
    }

    public static void main(String[] args) {
        // You need to provide a Context to use this class. In an Android app, you would typically do this in an Activity or Service.
        // For the sake of this example, let's assume we're in an Activity.
        // new SmsObserverRegistrar(this);
    }
}

class SmsSentObserver extends android.database.ContentObserver {
    public SmsSentObserver(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        // Handle the change here
    }
}