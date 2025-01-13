/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 */
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public class SmsObserverRegistrar {
    private Context context;

    public SmsObserverRegistrar(Context context) {
        this.context = context;
        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.registerContentObserver(Uri.parse((String)"content://sms/sent"), true, (ContentObserver)new SmsSentObserver(new Handler()));
    }

    public static void main(String[] stringArray) {
    }
}
