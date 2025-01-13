/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 */
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SmsUtils {
    public static int getUnreadSmsCount(Context context) {
        Uri uri = Uri.parse((String)"content://sms/inbox");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(uri, new String[]{"_id", "read"}, "read = ?", new String[]{"0"}, null);
        int n = cursor.getCount();
        cursor.close();
        return n;
    }

    public static void main(String[] stringArray) {
    }
}
