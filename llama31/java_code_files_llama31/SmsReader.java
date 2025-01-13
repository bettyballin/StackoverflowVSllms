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

public class SmsReader {
    public SmsReader(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(Uri.parse((String)"content://sms"), null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            }
            cursor.close();
        }
    }

    public static void main(String[] stringArray) {
    }
}
