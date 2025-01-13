import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.content.ContentResolver;

public class SmsReader {
    public SmsReader(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(Uri.parse("content://sms"), null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                // Do something with the message...
            }
            cursor.close();
        }
    }

    public static void main(String[] args) {
        // This code will not run on a standard Java environment because it needs an Android Context.
        // For testing purposes, you can use an Android emulator or a physical device.
        // Here is an example of how to use it in an Android Activity:
        // SmsReader smsReader = new SmsReader(this);
    }
}