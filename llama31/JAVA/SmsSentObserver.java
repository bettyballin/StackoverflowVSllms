import android.database.ContentObserver;
import android.os.Handler;

public class SmsSentObserver extends ContentObserver {
    public SmsSentObserver(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        // Handle the change here
    }

    public static void main(String[] args) {
    }
}