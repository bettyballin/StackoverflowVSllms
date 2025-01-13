import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class SmsUtils {
    public static int getUnreadSmsCount(Context context) {
        Uri smsUri = Uri.parse("content://sms/inbox");
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(smsUri, new String[]{"_id", "read"}, "read = ?", new String[]{"0"}, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public static void main(String[] args) {
        // You need to provide a Context to call getUnreadSmsCount
        // For example, if you're running this from an Activity:
        // Context context = this;
        // int unreadCount = getUnreadSmsCount(context);
        // System.out.println("Unread SMS count: " + unreadCount);
    }
}